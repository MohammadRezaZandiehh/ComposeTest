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
import androidx.compose.ui.unit.sp
import com.example.composetest.ui.theme.ComposeTestTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                Surface {
/*                    Row(
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
                    }*/


                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Timer(time = 100)
                        Timer(time = 100)
                    }


                }
            }
        }
    }

    //first way:

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


//another way:

    @Composable
    fun Timer(time: Int, startValue: Float = 0f) {

        var timeValue by remember {
            mutableStateOf(startValue)
        }

        var currentTime by remember {
            mutableStateOf(startValue)
        }

        var isTimerRunning by remember {
            mutableStateOf(false)
        }

        LaunchedEffect(key1 = currentTime, key2 = isTimerRunning) {
            if (/*currentTime > 0 &&*/ isTimerRunning) {
                delay(50)
                currentTime += 100
                timeValue = currentTime / time.toFloat()
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = (currentTime / 1000L).toString(),
                fontSize = 32.sp
            )

            Button(
                onClick = {
                    if (currentTime <= 0L) {
                        currentTime = time.toFloat()
                        isTimerRunning = true
                    }
                }
            ) {
                Text(text = "Start to Count")
            }
        }




}}