package br.com.renanalencar.screenrecorder.services

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.content.pm.ServiceInfo
import android.hardware.display.DisplayManager
import android.hardware.display.VirtualDisplay
import android.media.MediaRecorder
import android.media.projection.MediaProjection
import android.media.projection.MediaProjectionManager
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import androidx.core.app.NotificationCompat
import br.com.renanalencar.screenrecorder.MainActivity
import br.com.renanalencar.screenrecorder.R
import java.io.File

class ScreenRecordService : Service() {
    private lateinit var mediaProjectionManager: MediaProjectionManager
    private var mediaProjection: MediaProjection? = null
    private var mediaRecorder: MediaRecorder? = null
    private var handler: Handler? = null
    private var segmentDuration: Int = 10
    private var isRecording = false
    private var virtualDisplay: VirtualDisplay? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForegroundService()

        val resultCode = intent?.getIntExtra(
            MainActivity.EXTRA_SCREEN_CAPTURE_RESULT_CODE,
            Activity.RESULT_CANCELED
        )
        val data = intent?.getParcelableExtra<Intent>(MainActivity.EXTRA_SCREEN_CAPTURE_INTENT)
        segmentDuration = intent?.getIntExtra("segmentDuration", 10) ?: 10

        if (resultCode == Activity.RESULT_OK && data != null) {
            startScreenCapture(resultCode, data)
        } else {
            stopSelf()
        }

        return START_STICKY
    }

    private fun registerMediaProjectionCallback() {
        mediaProjection?.registerCallback(object : MediaProjection.Callback() {
            override fun onStop() {
                super.onStop()
                stopRecording() // Para a gravação corretamente se a projeção for interrompida
                stopSelf() // Encerra o serviço
            }
        }, handler)
    }


    private fun startScreenCapture(resultCode: Int, data: Intent) {
        mediaProjectionManager =
            getSystemService(MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
        mediaProjection = mediaProjectionManager.getMediaProjection(resultCode, data)

        if (mediaProjection != null) {
            registerMediaProjectionCallback()
            startRecording()
        } else {
            stopSelf()
        }
    }

    private fun startRecording() {
        mediaRecorder = MediaRecorder().apply {
//            setAudioSource(MediaRecorder.AudioSource.MIC)
            setVideoSource(MediaRecorder.VideoSource.SURFACE)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            setOutputFile(createNewFile())
            setVideoSize(1280, 720)
            setVideoEncoder(MediaRecorder.VideoEncoder.H264)
//            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            prepare()
        }
        virtualDisplay = mediaProjection?.createVirtualDisplay(
            "ScreenRecorder",
            1280, 720, resources.displayMetrics.densityDpi,
            DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
            mediaRecorder?.surface, null, null
        )

        mediaRecorder?.start()
        isRecording = true

        handler = Handler(Looper.getMainLooper())
        handler?.postDelayed({ stopSegmentAndRestart() }, (segmentDuration * 1000).toLong())
    }

    private fun stopRecording() {
        if (!isRecording) return

        try {
            mediaRecorder?.apply {
                stop()
                reset()
                release()
            }
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }

        mediaRecorder = null
        mediaProjection?.stop()
        mediaProjection = null

        isRecording = false

        // Para o foreground service e remove a notificação corretamente
        // API 34+
        stopForeground(STOP_FOREGROUND_REMOVE)

        stopSelf() // Encerra o serviço após parar a gravação
    }


    private fun stopSegmentAndRestart() {
        if (!isRecording) return

        try {
            mediaRecorder?.stop()
            mediaRecorder?.reset()
            if (isRecording) {
                startRecording()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            stopSelf()
        }
    }

    private fun createNewFile(): String {
        val directory = getExternalFilesDir(null)
        val fileName = "recording_${System.currentTimeMillis()}.mp4"
        return File(directory, fileName).absolutePath
    }

    private fun startForegroundService() {
        val notificationChannelId = "ScreenRecorderChannel"

        val channel = NotificationChannel(
            notificationChannelId,
            "Screen Recorder",
            NotificationManager.IMPORTANCE_LOW
        )
        val manager = getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(channel)

        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, notificationChannelId)
            .setContentTitle("Gravação de Tela em andamento")
            .setContentText("Seu vídeo está sendo gravado")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(
            1,
            notification,
            ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PROJECTION
        ) // ⬅️ Inicia o serviço em foreground
    }

    override fun onDestroy() {
        try {
            mediaRecorder?.stop()
            mediaRecorder?.release()
            virtualDisplay?.release()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        mediaRecorder = null

        mediaProjection?.stop()
        mediaProjection = null

        isRecording = false
        stopForeground(true)
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
