package com.jh.proj.testrepository.service

class EmailNotificationProvider : NotificationProvider {
    override fun sendNotification(message: String) {
        println("Sending email: $message")
    }
}