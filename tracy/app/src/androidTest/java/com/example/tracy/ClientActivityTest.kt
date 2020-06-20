package com.example.tracy

import android.view.InputDevice
import android.view.MotionEvent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.GeneralClickAction
import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Tap
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ClientActivityTest {


    @get:Rule
    val activityRule = ActivityTestRule(ClientActivity::class.java)

    @Test
    fun mapIsDisplayed() {
        onView(withId(R.id.map)).check(matches(isDisplayed()))
    }

    @Test
    fun mapCouldBeClicked() {
        onView(withId(R.id.map)).perform(click())
    }

    @Test
    fun fabShowsIfSelectedTwoPointsAtMap(){
        onView(withId(R.id.map)).perform(click())
        onView(withId(R.id.map)).perform(GeneralClickAction(
            Tap.SINGLE,
            GeneralLocation.CENTER_LEFT,
            Press.FINGER,
            InputDevice.SOURCE_UNKNOWN,
            MotionEvent.BUTTON_PRIMARY
        ), GeneralClickAction(
            Tap.SINGLE,
            GeneralLocation.BOTTOM_CENTER,
            Press.FINGER,
            InputDevice.SOURCE_UNKNOWN,
            MotionEvent.BUTTON_PRIMARY
        ))

        onView(withId(R.id.fab)).check(matches(isDisplayed()))
    }

    @Test
    fun fabCouldBeClicked(){
        onView(withId(R.id.map)).perform(click())
        onView(withId(R.id.map)).perform(GeneralClickAction(
            Tap.SINGLE,
            GeneralLocation.CENTER_LEFT,
            Press.FINGER,
            InputDevice.SOURCE_UNKNOWN,
            MotionEvent.BUTTON_PRIMARY
        ), GeneralClickAction(
            Tap.SINGLE,
            GeneralLocation.BOTTOM_CENTER,
            Press.FINGER,
            InputDevice.SOURCE_UNKNOWN,
            MotionEvent.BUTTON_PRIMARY
        ))

        onView(withId(R.id.fab)).perform(click())
    }

}