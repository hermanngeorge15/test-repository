package com.jh.proj.testrepository.service

import java.time.LocalDateTime
import java.util.concurrent.*

class NotificationService(
    private val providers: List<NotificationProvider>,
    private val retryAttempts: Int = 3
) {
    private val notificationLog = ConcurrentHashMap<String, NotificationStatus>()

    fun sendNotification(
        message: String,
        template: NotificationTemplate? = null,
        priority: NotificationPriority = NotificationPriority.NORMAL
    ): String {
        val notificationId = generateNotificationId()
        val finalMessage = template?.format(message) ?: message

        notificationLog[notificationId] = NotificationStatus(
            message = finalMessage,
            timestamp = LocalDateTime.now(),
            priority = priority,
            status = DeliveryStatus.PENDING
        )

        try {
            var attempts = 0
            var success = false

            while (attempts < retryAttempts && !success) {
                try {
                    providers.forEach { provider ->
                        provider.sendNotification(finalMessage)
                    }
                    success = true
                    notificationLog[notificationId]?.status = DeliveryStatus.DELIVERED
                } catch (e: Exception) {
                    attempts++
                    if (attempts == retryAttempts) {
                        notificationLog[notificationId]?.status = DeliveryStatus.FAILED
                        throw NotificationException("Failed to send notification after $retryAttempts attempts", e)
                    }
                }
            }
        } catch (e: Exception) {
            notificationLog[notificationId]?.status = DeliveryStatus.FAILED
            throw e
        }

        return notificationId
    }

    fun getNotificationStatus(notificationId: String): NotificationStatus? =
        notificationLog[notificationId]

    private fun generateNotificationId(): String =
        System.currentTimeMillis().toString() + "-" + (0..999).random()
}