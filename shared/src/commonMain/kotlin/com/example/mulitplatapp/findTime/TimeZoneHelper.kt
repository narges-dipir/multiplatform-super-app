package com.example.mulitplatapp.findTime

interface TimeZoneHelper {
    fun getTimeZoneStrings(): List<String>
    fun currentTime(): String
    fun currentTimeZone(): String
    fun hoursFromTimeZone(otherTimeZoneId: String): Double
    fun getTime(timeZoneId: String): String
    fun getDate(timeZoneId: String): String
    fun search(startHour: Int, endHour: Int, timeZoneString: List<String>): List<Int>
}