package com.example.composetest.screen.HotScreen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.components.RoundedIconBox
import com.example.composetest.screen.FinanceScreen.FinanceScreen
import com.example.composetest.screen.GoldScreen.GoldScreen
import com.example.composetest.ui.theme.DarkYellow
import com.example.composetest.R
import com.example.composetest.screen.HotScreen.CounterHelper.processInput


@Composable
fun TabScreen(context: Context) {
    var tabIndex by remember { mutableStateOf(2) }
    val tabs = listOf("\uD83D\uDCB0مالی", "\uD83E\uDD47طلایی", "\uD83D\uDD25داغ")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(
                RoundedCornerShape(
                    topEnd = 12.dp,
                    topStart = 12.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                )
            )
            .background(Color.White)
    ) {

        TabRow(
            selectedTabIndex = tabIndex,
            backgroundColor = Color.White,
            divider = {},
            indicator = {
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(it[tabIndex])
                        .background(DarkYellow)
                        .size(2.dp)
                )
            }

        ) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(text = title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }

        when (tabIndex) {
            0 -> FinanceScreen(context)
            1 -> GoldScreen()
            2 -> HotScreen()
        }
    }
}

@Composable
fun HotScreen() {
    val scrollState = rememberLazyListState()
    LazyColumn(
        state = scrollState,
        modifier = Modifier
    ) {
        item {
            CounterDisplay(modifier = Modifier)
/*            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                RoundedIconBox(
                    title = "اسنپ",
                    image = painterResource(id = R.drawable.snapp)
                )

                RoundedIconBox(
                    title = "اسنپ فود",
                    image = painterResource(id = R.drawable.snap_food)
                )

                RoundedIconBox(
                    title = "جاجیگا",
                    image = painterResource(id = R.drawable.jajiga)
                )

                RoundedIconBox(
                    title = "جاباما",
                    image = painterResource(id = R.drawable.jabama)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceAround

            ) {
                RoundedIconBox(
                    title = "بامن",
                    image = painterResource(id = R.drawable.baman)
                )

                RoundedIconBox(
                    title = "ترنج",
                    image = painterResource(id = R.drawable.toranj)
                )

                RoundedIconBox(
                    title = "بازار",
                    image = painterResource(id = R.drawable.bazar)
                )

                RoundedIconBox(
                    title = "ایتا",
                    image = painterResource(id = R.drawable.ita)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                RoundedIconBox(
                    title = "لنز",
                    image = painterResource(id = R.drawable.lenz)
                )

                RoundedIconBox(
                    title = "مفید",
                    image = painterResource(id = R.drawable.mofid)
                )

                RoundedIconBox(
                    title = "علی بابا",
                    image = painterResource(id = R.drawable.alibaba)
                )

                RoundedIconBox(
                    title = "بامن",
                    image = painterResource(id = R.drawable.baman)
                )
            }*/
        }
    }
}

@Composable
fun CounterDisplay(
    modifier: Modifier
) {
    var editedText by remember { mutableStateOf("") }
    var counterText by remember { mutableStateOf("Start copying") }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.testTag("Counter Display"),
            text = counterText,
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Black
            )
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .testTag("Input"),
            value = editedText,
            onValueChange = {
                editedText = it
            },
            label = {
                Text("Input")
            },
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
            ),
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                counterText = processInput(editedText)
            }
        ) {
            Text(
                modifier = Modifier
                    .testTag("Copy"),
                text = "Copy",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
                )
            )
        }
    }
}


object CounterHelper {

    fun processInput(editedText: String): String {
        return try {
            val counterValue = editedText.toInt()
            "Counter = $counterValue"
        } catch (e: NumberFormatException) {
            "Invalid entry"
        }
    }
}