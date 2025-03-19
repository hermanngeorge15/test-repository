package com.jh.proj.testrepository.service

interface NotificationTemplate {
    fun format(message: String): String
}