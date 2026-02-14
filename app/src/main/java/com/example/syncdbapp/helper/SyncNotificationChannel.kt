package com.example.syncdbapp.helper

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

object SyncNotificationChannel {

    const val CHANNEL_ID = "sync_channel_id"
    private const val CHANNEL_NAME = "Background Sync"
    private const val CHANNEL_DESC = "Shows progress of background data sync and uploads"

    fun create(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = CHANNEL_DESC
                setShowBadge(false)
            }

            val manager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            manager.createNotificationChannel(channel)
        }
    }
}
