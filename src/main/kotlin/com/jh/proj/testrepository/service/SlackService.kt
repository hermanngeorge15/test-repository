package com.jh.proj.testrepository.service

class SlackService {
    fun sendMessage(message: String) {
        println("Sending message to Slack: $message")
    }

    fun sendErrorMessage(message: String) {
        println("Sending error message to Slack: $message")
    }
}