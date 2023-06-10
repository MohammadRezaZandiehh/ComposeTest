package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {

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
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.White)
                                .fillMaxWidth()
                                .padding(4.dp)
                                .size(200.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    EntireBudget()
                                    EntireGeneral()
                                }
                            }


                        }
                    }
                }
            }
        }
    }

    //    @Preview
    @Composable
    fun UserInfo() {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Yellow)
                    .size(44.dp),
            ) {
                Image(
                    modifier = Modifier.padding(8.dp),
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = "",
                )

                Image(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(id = R.drawable.fire),
                    contentDescription = "",
                    alignment = Alignment.TopStart
                )
            }


            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Yellow)
                    .padding(2.dp)

            ) {

                Image(
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = "",
                    modifier = Modifier
                        .size(16.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 40.dp)
                ) {


                    Column(
                        modifier = Modifier
                            .padding(horizontal = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Mohammadreza",
                            fontWeight = FontWeight.Thin,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(vertical = 2.dp)
                        )

                        Text(
                            text = "09203903530",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Thin
                        )
                    }

                    Image(
                        modifier = Modifier
                            .size(30.dp),
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground),
                        painter = painterResource(id = R.drawable.irancell),
                        contentDescription = "",
                    )
                }
            }
        }
    }


    //    @Preview
    @Composable
    fun EntireGeneral() {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(4.dp),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 1.dp, bottom = 2.dp),
                    text = "کارکرد کل",
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )

                Text(
                    modifier = Modifier.padding(top = 1.dp, bottom = 4.dp),
                    text = "4443/03 ریال",
                    fontWeight = FontWeight.Bold
                )

                Row(
                    Modifier
                        .padding(top = 4.dp, bottom = 18.dp, start = 4.dp, end = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .background(Color.LightGray, shape = CircleShape)
                    ) {
                        Image(
                            modifier = Modifier
                                .size(24.dp)
                                .padding(4.dp),
                            painter = painterResource(id = R.drawable.arrow),
                            contentDescription = ""
                        )
                    }


                    Card(
                        modifier = Modifier
                            .padding(start = 4.dp),
                        shape = RoundedCornerShape(10.dp),
                    ) {
                        Text(
                            modifier = Modifier
                                .background(Yellow)
                                .padding(horizontal = 10.dp, vertical = 4.dp),
                            text = "پرداخت میان دوره"
                        )
                    }
                }
            }
        }
    }

//    @Preview
    @Composable
    fun EntireBudget() {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(4.dp),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 1.dp, bottom = 2.dp),
                    text = "کارکرد کل",
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )

                Text(
                    modifier = Modifier.padding(top = 1.dp, bottom = 4.dp),
                    text = "4443/03 ریال",
                    fontWeight = FontWeight.Bold
                )


                    Card(
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 18.dp, start = 8.dp, end = 8.dp),
                        shape = RoundedCornerShape(10.dp),
                    ) {
                        Text(
                            modifier = Modifier
                                .background(Color.Green)
                                .padding(horizontal = 20.dp, vertical = 4.dp),
                            text = "مدیریت جیب جت"
                        )
                    }
                }
            }
    }

}













