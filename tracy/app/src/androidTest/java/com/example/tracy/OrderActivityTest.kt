package com.example.tracy

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.tracy.utils.Activities
import junit.framework.TestCase.assertTrue
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
class OrderActivityTest {

    val defaultPhoneString = "+71234567890"
    val defaultDescription = "This is description with a lot of letters"
    val defaultName = "Cargo"
    val defaultPrice = "300$"

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.example.tracy", appContext.packageName)
    }

    @get:Rule
    val activityRule = ActivityTestRule(OrderActivity::class.java)

    @Test
    fun contentIsDisplayed() {
        onView(withId(R.id.editTextPhone)).check(matches(isDisplayed()))
        onView(withId(R.id.editTextTextMultiLine)).check(matches(isDisplayed()))
        onView(withId(R.id.editTextTextPrice)).check(matches(isDisplayed()))
        onView(withId(R.id.editTextTextPersonName)).check(matches(isDisplayed()))
    }

    @Test
    fun cannotBeSubmittedWithoutPhone(){
        withDefaultName()
        withDefaultDescription()
        withDefaultPrice()

        onView(withId(R.id.submit)).perform(click())
        onView(withId(R.id.errorMessage)).check(matches(isDisplayed()))
        assertTrue(Activities.getActivityInstance() is OrderActivity)
    }

    @Test
    fun cannotBeSubmittedWithoutName(){
        withDefaultPhone()
        withDefaultDescription()
        withDefaultPrice()

        onView(withId(R.id.submit)).perform(click())
        onView(withId(R.id.errorMessage)).check(matches(isDisplayed()))
        assertTrue(Activities.getActivityInstance() is OrderActivity)
    }

    private fun withDefaultPhone() {
        onView(withId(R.id.editTextPhone))
            .perform(typeText(defaultPhoneString))
        Espresso.closeSoftKeyboard()
    }

    private fun withDefaultDescription() {
        onView(withId(R.id.editTextTextMultiLine))
            .perform(typeText(defaultDescription))
        Espresso.closeSoftKeyboard()
    }

    private fun withDefaultName() {
        onView(withId(R.id.editTextTextPersonName))
            .perform(typeText(defaultName))
        Espresso.closeSoftKeyboard()
    }

    private fun withDefaultPrice() {
        onView(withId(R.id.editTextTextPrice))
            .perform(typeText(defaultPrice))
        Espresso.closeSoftKeyboard()
    }




}
