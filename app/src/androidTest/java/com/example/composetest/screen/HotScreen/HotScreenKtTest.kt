package com.example.composetest.screen.HotScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.composetest.ui.theme.ComposeTestTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HotScreenKtTest {

    @get: Rule
    val composeTestRule =
        createComposeRule()   // compose rule is required to get access to the composable component

    @Before
    fun setUp() {
        composeTestRule.setContent {    // setting our composable as content for test
            ComposeTestTheme {
                CounterDisplay(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                )
            }
        }
    }

//    Test Case 1: Initial state
//    At first, we simply verify if all of our views in the default state exist or not:

    @Test
    fun verify_if_all_views_exists() {
        composeTestRule.onNodeWithTag("Counter Display")
        composeTestRule.onNodeWithTag("Input")
        composeTestRule.onNodeWithTag("Copy")
    }
//    composeTestRule.onNodeWithTag indicates that a component with
//    testing tag as “Counter Display” exists or not.

//    onNodeWithText and onNodeWithTag are of the same purpose here but we can use either.
//.........................

    @Test
    fun counterValue_with_emptyInput_displays_InvalidEntry() {
//        var counterText = remember { mutableStateOf("Start copying") }
        composeTestRule.onNodeWithText("Copy").performClick()
        composeTestRule.onNodeWithTag("Counter Display").assertTextEquals("Invalid entry")
    }

//.........................

    @Test
    fun withInput_as_1_onButtonClick_displayOnTop() {
        composeTestRule.onNodeWithTag("Input").performTextInput("1")
        composeTestRule.onNodeWithText("Copy").performClick()
        composeTestRule.onNodeWithTag("Counter Display").assertTextEquals("Counter = 1")
//        composeTestRule.onNodeWithTag("Counter Display").assertTextContains("Counter = 1")     <-- it's ok too

    }
}