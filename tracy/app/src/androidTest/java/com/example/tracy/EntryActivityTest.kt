package com.example.tracy

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
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
class EntryActivityTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.example.tracy", appContext.packageName)
    }

    @get:Rule
    val activityRule = ActivityTestRule(EntryActivity::class.java)

    @Test
    fun contentIsDisplayed() {
        onView(withId(R.id.driver)).check(matches(isDisplayed()))
        onView(withId(R.id.client)).check(matches(isDisplayed()))
        onView(withId(R.id.entryHeader1)).check(matches(isDisplayed()))
        onView(withId(R.id.entryHeader2)).check(matches(isDisplayed()))
    }

    @Test
    fun goesToDriverActivityIfPressedDriver() {

        onView(withId(R.id.driver))
            .perform(click())

        val activity = Activities.getActivityInstance()
        assertTrue(activity is DriverActivity)
    }

    @Test
    fun goesToClientActivityIfPressedClient() {

        onView(withId(R.id.client))
            .perform(click())

        val activity = Activities.getActivityInstance()
        assertTrue(activity is ClientActivity)
    }

    @Test
    fun goesToAboutActivityIfPressedAbout() {

        onView(withId(R.id.about))
            .perform(click())

        val activity = Activities.getActivityInstance()
        assertTrue(activity is AboutActivity)
    }


}
