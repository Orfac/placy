package com.example.tracy

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.tracy.utils.Activities
import junit.framework.Assert.*
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class DriverActivityTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.example.tracy", appContext.packageName)
    }

    @get:Rule
    val activityRule = ActivityTestRule(DriverActivity::class.java)

    @Test
    fun contentIsDisplayed() {
        onView(withText("2 тонны щебня")).check(matches(isDisplayed()))
    }




}
