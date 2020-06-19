package com.example.tracy

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.tracy", appContext.packageName)
    }

    @get:Rule
    val activityRule = ActivityTestRule(MapsActivity::class.java)

    @Test fun listGoesOverTheFold() {
        onView(withText("Привет всем")).check(matches(isDisplayed()))
    }

    @Test fun fabIsDisplayed() {
        onView(withId(R.id.fab)).check(matches(isDisplayed()))
    }

    @Test fun mapIsDisplayed() {
        onView(withId(R.id.map)).check(matches(isDisplayed()))
    }

    @Test fun fabIsCouldBeClicked() {
        onView(withId(R.id.fab))
            .perform(click())
            .check(matches(isDisplayed()))
    }

}
