package com.example.composetest.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.composetest.ui.theme.Green
import com.example.composetest.ui.theme.Yellow
import com.example.composetest.R

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
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                Text(
                    modifier = Modifier.padding(top = 1.dp, bottom = 4.dp),
                    text = "4443/03 ریال",
                    fontWeight = FontWeight.Bold
                )
            }

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
                        .padding(start = 4.dp, end = 4.dp),
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
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                Text(
                    modifier = Modifier.padding(top = 1.dp, bottom = 4.dp),
                    text = "4443/03 ریال",
                    fontWeight = FontWeight.Bold
                )
            }


            Card(
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 18.dp, start = 8.dp, end = 8.dp),
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(
                    modifier = Modifier
                        .background(Green)
                        .padding(horizontal = 20.dp, vertical = 4.dp),
                    text = "مدیریت جیب جت"
                )
            }
        }
    }
}