package br.com.renanalencar.screenrecorder.viewmodels

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import br.com.renanalencar.screenrecorder.services.ScreenRecordService

class ScreenRecorderViewModel(application: Application) : AndroidViewModel(application) {
    private var screenRecordService: ScreenRecordService? = null

    fun startRecording(segmentDuration: Int) {
        val intent = Intent(getApplication(), ScreenRecordService::class.java)
        intent.putExtra("segmentDuration", segmentDuration)
        getApplication<Application>().startService(intent)
    }

    fun stopRecording() {
        val intent = Intent(getApplication(), ScreenRecordService::class.java)
        getApplication<Application>().stopService(intent)
    }
}
