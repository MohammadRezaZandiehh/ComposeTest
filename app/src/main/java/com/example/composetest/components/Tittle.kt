package com.example.composetest.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.R


@Composable
fun Tittle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {

        Text(
            modifier = Modifier
                .padding(end = 8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            text = "! ایرانسل را بازی کنید و جایزه ببرید"
        )


        Image(
            modifier = Modifier
                .size(20.dp)
                .padding(end = 2.dp),
            painter = painterResource(id = R.drawable.wallet),
            contentDescription = ""
        )


    }
}