package com.hpnightowl.opener

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hpnightowl.opener.ui.theme.OpenerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenerTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    SenderScreen()
                }
            }
        }
    }

    @Composable
    fun SenderScreen() {
            Button(
                modifier = Modifier.padding(16.dp),
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse("https://example.app/details/99")
                    }
                    startActivity(intent)
                }
            ) {
                Text("Open Receiver App with Deep Link")
            }
        }
}
