package com.example.composetest.screen.FinanceScreen

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import com.example.composetest.MapActivity

@Composable
fun FinanceScreen(context: Context) {
    context.startActivity(Intent(context, MapActivity::class.java))
}
