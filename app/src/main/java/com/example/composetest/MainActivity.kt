package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest.ui.theme.ComposeTestTheme
import com.example.composetest.ui.theme.Shapes
import com.example.composetest.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                Surface {
                    Box(
                        modifier = Modifier
                            .background(Teal200)
                            .fillMaxSize()
                    ) {
                        UserInfo()

                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun UserInfo() {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Yellow)
                .padding(vertical = 4.dp, horizontal = 2.dp)

        ) {

            Row(
                modifier = Modifier.weight(0.80f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "",
                )

                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Mohammadreza",
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    )

                    Text(
                        text = "09203903530",
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Image(
                modifier = Modifier
                    .weight(0.20f),
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = "",
            )
        }
    }
}
//}













