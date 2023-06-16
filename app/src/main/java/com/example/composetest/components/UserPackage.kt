package com.example.composetest.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.ui.theme.DarkYellow
import com.example.composetest.ui.theme.Yellow

@Composable
fun UserPackage(
    @DrawableRes image: Int,
    text: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {

        Box(
            modifier = Modifier
                .padding(vertical = 6.dp)
                .background(DarkYellow, shape = CircleShape)
                .size(60.dp)
        ) {
            Image(
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = image),
                contentScale = ContentScale.Fit,
                contentDescription = "",
            )
        }

        Card(
            modifier = Modifier
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(
                modifier = Modifier
                    .background(Yellow)
                    .padding(horizontal = 6.dp, vertical = 6.dp),
                fontSize = (10.sp),
                fontWeight = FontWeight.Bold,
                text = text
            )
        }
    }
}