package com.example.composetest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.composetest.components.*
import com.example.composetest.model.Product
import com.example.composetest.remote.NetworkResult
import com.example.composetest.screen.HotScreen.TabScreen
import com.example.composetest.ui.theme.*
import com.example.composetest.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ComposeTestTheme {
                Surface {
                    Column(
                        modifier = Modifier
                            .background(DarkYellow)
                            .fillMaxSize()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                        ) {
                            UserInfo()
                        }

                        Box(
                            modifier = Modifier
                                .clip(
                                    shape = RoundedCornerShape(
                                        topStart = 12.dp,
                                        topEnd = 12.dp,
                                        bottomStart = 0.dp,
                                        bottomEnd = 0.dp
                                    )
                                )
                                .background(Color.LightGray)
                                .fillMaxSize()
                        ) {

                            Column() {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(Color.White)
                                        .fillMaxWidth()
                                        .padding(4.dp)
                                        .size(250.dp)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(bottom = 12.dp),
                                            horizontalArrangement = Arrangement.SpaceEvenly
                                        ) {
                                            EntireBudget()
                                            EntireGeneral()
                                        }

                                        LazyRow(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(horizontal = 4.dp),
                                            horizontalArrangement = Arrangement.SpaceEvenly
                                        ) {
                                            item {

                                                Flash(
                                                    R.drawable.ic_arrow_left
                                                )

                                                CustomCircularProgressIndicator(
                                                    modifier = Modifier
                                                        .size(80.dp)
                                                        .background(Color.White),
                                                    initialValue = 90,
                                                    primaryColor = Green,
                                                    secondaryColor = Color.LightGray,
                                                    circleRadius = 90f,
                                                    onPositionChange = {}
                                                )

                                                UserPackage(
                                                    R.drawable.people,
                                                    text = "خرید بسته مکالمه"
                                                )

                                                UserPackage(
                                                    R.drawable.people,
                                                    text = "خرید بسته پیشنهادی"
                                                )

                                                UserPackage(
                                                    R.drawable.people,
                                                    text = "خرید بسته اینترنت"
                                                )

                                                Flash(
                                                    R.drawable.ic_arrow_right
                                                )
                                            }
                                        }
                                    }
                                }


                                Spacer(modifier = Modifier.height(8.dp))

                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(Color.White)
                                        .fillMaxWidth()
                                        .padding(4.dp)
                                ) {
                                    Tittle()
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                TabScreen()

                            }
                        }
                    }
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun Preview() {

    }
}













