package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composetest.ui.theme.ComposeTestTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                Surface {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column(
                            horizontalAlignment = Alignment.End,
                        ) {
                            TimerButton("start / reset 1")
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(
                            horizontalAlignment = Alignment.Start,
                        ) {
                            TimerButton("start / reset 2")
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun TimerButton(
        textBtn: String
    ) {
        var ticks by remember { mutableStateOf(0) }
        var isStart by remember { mutableStateOf(false) }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                modifier = Modifier.padding(16.dp),
                text = ticks.toString()
            )


            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White
                ), onClick = {
                    isStart = isStart == false
                }
            ) {
                Text(text = textBtn)
            }

            if (isStart) {
                LaunchedEffect(Unit) {
                    while (true) {
                        delay(1.seconds)
                        ticks++
                    }
                }
            } else {
                ticks = 0
            }
        }
    }
}