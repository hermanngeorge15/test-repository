package com.jh.proj.testrepository.service

class SlackNotificationProvider(private val slackService: SlackService) : NotificationProvider {
    override fun sendNotification(message: String) {
        slackService.sendMessage(message)
    }
}