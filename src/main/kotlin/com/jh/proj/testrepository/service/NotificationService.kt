package com.jh.proj.testrepository.service

class NotificationService {
    fun sendNotification(message: String) {
        println("Sending notification: $message")
    }

    fun sendErrorMessage(message: String) {
        println("Sending error message: $message")
    }
}