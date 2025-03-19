package com.jh.proj.testrepository.service

class SlackService {
    fun sendMessage(message: String) {
        println("Sending message to Slack: $message")
    }

    fun getChannelMembers(channel: String): List<String> {
        println("Getting members of channel: $channel")
        return listOf("Alice", "Bob", "Charlie")
    }

    fun getChannelMessages(channel: String): List<String> {
        println("Getting messages of channel: $channel")
        return listOf("Message 1", "Message 2", "Message 3")
    }

    fun getChannelInfo(channel: String): Map<String, Any> {
        println("Getting info of channel: $channel")
        return mapOf(
            "name" to "general",
            "members" to listOf("Alice", "Bob", "Charlie"),
            "messages" to listOf("Message 1", "Message 2", "Message 3")
        )
    }
}