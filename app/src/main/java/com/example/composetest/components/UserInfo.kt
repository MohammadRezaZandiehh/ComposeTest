package com.example.composetest.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.ui.theme.Yellow
import com.example.composetest.R

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

            Box(
                Modifier
                    .background(Color.Red, shape = CircleShape)
                    .height(16.dp)
                    .width(16.dp)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    fontSize = 10.sp,
                    text = "18"
                )
            }
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
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .padding(vertical = 2.dp)
                    )

                    Text(
                        text = "09203903530",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
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