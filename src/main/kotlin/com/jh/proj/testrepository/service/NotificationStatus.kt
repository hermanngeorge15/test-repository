package com.jh.proj.testrepository.service

import java.time.LocalDateTime

data class NotificationStatus(
    val message: String,
    val timestamp: LocalDateTime,
    val priority: NotificationPriority,
    var status: DeliveryStatus
)