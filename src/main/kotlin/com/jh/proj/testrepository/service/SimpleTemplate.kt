package com.jh.proj.testrepository.service

class SimpleTemplate(private val prefix: String = "", private val suffix: String = "") :
    NotificationTemplate {
    override fun format(message: String): String = "$prefix$message$suffix"
}