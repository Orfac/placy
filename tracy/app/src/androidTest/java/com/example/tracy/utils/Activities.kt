package com.example.tracy.utils

import android.app.Activity
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage
import java.lang.Exception


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
            throw IllegalStateException("Cannot get current activity")
        return currentActivity!!
    }
}