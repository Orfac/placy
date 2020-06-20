package com.example.tracy.utils

import android.app.Activity
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage


object Activities {
     var currentActivity: Activity? = null

    fun getActivityInstance(): Activity {
        getInstrumentation().runOnMainSync {
            val resumedActivities =
                ActivityLifecycleMonitorRegistry.getInstance()
                    .getActivitiesInStage(Stage.RESUMED)
            for (activity in resumedActivities) {
                currentActivity = activity
                break
            }
        }
        if (currentActivity == null)
            throw Exception("Cannot get current activity")
        return currentActivity!!
    }
}