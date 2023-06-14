package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.composetest.ui.theme.*

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
                CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
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
                CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
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


    //    @Preview
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

    @Composable
    fun RoundedIconBox(
        title: String,
        image: Painter,
        bgColor: Color = Color.Transparent,
    ) {
        Column(
            modifier = Modifier
                .width(80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(18.dp))
                    .background(bgColor)
            ) {
                Image(
                    painter = image,
                    contentDescription = "",
                    modifier = Modifier.size(52.dp)
                )
            }

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }


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

    @Composable
    fun GoldScreen() {

    }

    @Composable
    fun FinanceScreen() {

    }

    @Composable
    fun Flash(
        @DrawableRes image: Int,
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                modifier = Modifier
                    .size(16.dp),
                painter = painterResource(image),
                contentDescription = ""
            )
        }
    }


    @Composable
    fun Chart(
        values: Float = 120f,
        colors: Color = Green,
        backgroundCircleColor: Color = Color.LightGray.copy(alpha = 0.2f),
        size: Dp = 100.dp,
        thickness: Dp = 6.dp,
        gapBetweenCircles: Dp = 42.dp
    ) {

        // Convert each value to angle
        val sweepAngles = values.compareTo(360 * 120 / 100).toFloat()

        Column(
            modifier = Modifier/*.height(180.dp)*/
                .background(Color.Yellow),
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .height(90.dp),
                contentAlignment = Alignment.TopCenter,
            ) {

                Canvas(
                    modifier = Modifier
                        .size(size)
                        .align(Alignment.TopCenter)
                ) {

                    var arcRadius = size.toPx()

                    arcRadius -= gapBetweenCircles.toPx()


                    drawCircle(
                        color = backgroundCircleColor,
                        radius = arcRadius / 2,
                        style = Stroke(width = thickness.toPx(), cap = StrokeCap.Butt),
                    )

                    drawArc(
                        color = colors,
                        startAngle = -90f,
                        sweepAngle = 90f,
                        useCenter = false,
                        style = Stroke(width = thickness.toPx(), cap = StrokeCap.Round),
                        size = Size(arcRadius, arcRadius),
                        topLeft = Offset(
                            x = (size.toPx() - arcRadius) / 2,
                            y = (size.toPx() - arcRadius) / 2
                        )
                    )
                }

                CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.Center),
                        textAlign = TextAlign.Center,
                        text = "44.5 مگ",
                        fontSize = (10.sp),
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
            Card(
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(
                    modifier = Modifier
                        .background(Yellow)
                        .padding(horizontal = 6.dp, vertical = 6.dp),
                    fontSize = (10.sp),
                    fontWeight = FontWeight.Bold,
                    text = "خرید بسته اینترنت"
                )
            }
        }

    }

    @Composable
    fun CustomCircularProgressIndicator(
        modifier: Modifier = Modifier,
        initialValue: Int,
        primaryColor: Color,
        secondaryColor: Color,
        minValue: Int = 0,
        maxValue: Int = 100,
        circleRadius: Float,
        onPositionChange: (Int) -> Unit
    ) {
        var circleCenter by remember {
            mutableStateOf(Offset.Zero)
        }

        var positionValue by remember {
            mutableStateOf(initialValue)
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = modifier
            ) {
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    val width = size.width
                    val height = size.height
                    val circleThickness = width / 20
                    circleCenter = Offset(x = width / 2f, y = height / 2f)

                    drawCircle(
                        color = Color.White,
                        radius = circleRadius,
                        center = circleCenter
                    )


                    drawCircle(
                        style = Stroke(
                            width = circleThickness
                        ),
                        color = secondaryColor,
                        radius = circleRadius,
                        center = circleCenter
                    )

                    drawArc(
                        color = primaryColor,
                        startAngle = -90f,
                        sweepAngle = 90f,/*(360f / maxValue) * positionValue.toFloat(),*/
                        style = Stroke(
                            width = circleThickness,
                            cap = StrokeCap.Round
                        ),
                        useCenter = false,
                        size = Size(
                            width = circleRadius * 2f,
                            height = circleRadius * 2f
                        ),
                        topLeft = Offset(
                            (width - circleRadius * 2f) / 2f,
                            (height - circleRadius * 2f) / 2f
                        )

                    )
                }

                CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.Center),
                        textAlign = TextAlign.Center,
                        text = "44.5 مگ",
                        fontSize = (10.sp),
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
            Card(
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(
                    modifier = Modifier
                        .background(Yellow)
                        .padding(horizontal = 6.dp, vertical = 6.dp),
                    fontSize = (10.sp),
                    fontWeight = FontWeight.Bold,
                    text = "خرید بسته اینترنت"
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview() {

    }
}













