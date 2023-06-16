package com.example.composetest.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.ui.theme.Green
import com.example.composetest.ui.theme.Yellow

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

            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
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