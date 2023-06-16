package com.example.composetest.screen.HotScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composetest.components.RoundedIconBox
import com.example.composetest.screen.FinanceScreen.FinanceScreen
import com.example.composetest.screen.GoldScreen.GoldScreen
import com.example.composetest.ui.theme.DarkYellow
import com.example.composetest.R



@Composable
fun TabScreen() {
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
            0 -> FinanceScreen()
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

            Row(
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
            }
        }
    }
}