package com.livefast.eattrash.raccoonforfriendica.domain.identity.usecase.pullnotifications

import android.app.ActivityManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class DefaultPullNotificationChecker(
    private val context: Context,
) : PullNotificationChecker {
    override val isBackgroundCheckSupported = true
    override val isBackgroundRestricted: Boolean
        get() =
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O_MR1) {
                (context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager).isBackgroundRestricted
            } else {
                false
            }

    private var intervalMinutes = 15L

    override fun setPeriod(minutes: Long) {
        intervalMinutes = minutes
    }

    override fun start() {
        WorkManager.getInstance(context).cancelAllWorkByTag(TAG)

        createNotificationChannel()

        val constraints =
            Constraints
                .Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

        // check immediately with an expedited one-time request
        OneTimeWorkRequestBuilder<CheckNotificationWorker>()
            .addTag(TAG)
            .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
            .setConstraints(constraints)
            .build()
            .also { req ->
                WorkManager.getInstance(context).enqueue(req)
            }

        // schedule periodic subsequent checks
        PeriodicWorkRequestBuilder<CheckNotificationWorker>(
            repeatInterval = intervalMinutes,
            repeatIntervalTimeUnit = TimeUnit.MINUTES,
        ).addTag(TAG)
            .setConstraints(constraints)
            .setInitialDelay(
                duration = 5,
                timeUnit = TimeUnit.MINUTES,
            ).build()
            .also { req ->
                WorkManager.getInstance(context).enqueue(req)
            }
    }

    override fun stop() {
        WorkManager.getInstance(context).cancelAllWorkByTag(TAG)
    }

    private fun createNotificationChannel() {
        val descriptionText = ""
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel =
            NotificationChannel(
                NotificationConstants.CHANNEL_ID,
                NotificationConstants.CHANNEL_NAME,
                importance,
            ).apply {
                description = descriptionText
            }
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    companion object {
        private const val TAG = "PullNotificationChecker"
    }
}
