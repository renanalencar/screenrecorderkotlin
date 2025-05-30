package br.com.renanalencar.screenrecorder

import android.content.Intent
import android.media.projection.MediaProjectionManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import br.com.renanalencar.screenrecorder.services.ScreenRecordService
import br.com.renanalencar.screenrecorder.ui.theme.ScreenRecorderTheme
import br.com.renanalencar.screenrecorder.viewmodels.ScreenRecorderViewModel

class MainActivity : ComponentActivity() {
    private val screenRecorderViewModel: ScreenRecorderViewModel by viewModels()
    private val screenCaptureLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                val serviceIntent = Intent(this, ScreenRecordService::class.java).apply {
                    putExtra(EXTRA_SCREEN_CAPTURE_INTENT, data)
                    putExtra(EXTRA_SCREEN_CAPTURE_RESULT_CODE, result.resultCode)
                }
                startService(serviceIntent)
            }
            finish() // Fecha a Activity após processar o resultado
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mediaProjectionManager =
            getSystemService(MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
        val captureIntent = mediaProjectionManager.createScreenCaptureIntent()
        screenCaptureLauncher.launch(captureIntent)
        enableEdgeToEdge()
        setContent {
            ScreenRecorderTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenRecorderUI(screenRecorderViewModel)
                }
            }
        }
    }

    companion object {
        const val EXTRA_SCREEN_CAPTURE_INTENT = "extra_screen_capture_intent"
        const val EXTRA_SCREEN_CAPTURE_RESULT_CODE = "extra_screen_capture_result_code"
    }
}

@Composable
fun ScreenRecorderUI(viewModel: ScreenRecorderViewModel) {
    var isRecording by remember { mutableStateOf(false) }
    var segmentDuration by remember { mutableStateOf("10") } // Padrão: 10 segundos

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            isRecording = true
            viewModel.startRecording(segmentDuration.toIntOrNull() ?: 10)
        }) {
            Text("Iniciar Gravação")
        }

        if (isRecording) {
            Button(onClick = {
                isRecording = false
                viewModel.stopRecording()
            }) {
                Text("Parar Gravação")
            }
        }

        TextField(
            value = segmentDuration,
            onValueChange = { segmentDuration = it },
            label = { Text("Duração do Segmento (s)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
    }
}