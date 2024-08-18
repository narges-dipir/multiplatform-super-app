package com.example.mulitplatapp.findTime

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone

class TimeZoneHelperImpl: TimeZoneHelper {

    override fun getTimeZoneStrings(): List<String> {
        return TimeZone.availableZoneIds.sorted()
    }

    override fun currentTime(): String {
        TODO("Not yet implemented")
    }

    override fun currentTimeZone(): String {
        TODO("Not yet implemented")
    }

    override fun hoursFromTimeZone(otherTimeZoneId: String): Double {
        TODO("Not yet implemented")
    }

    override fun getTime(timeZoneId: String): String {
        TODO("Not yet implemented")
    }

    override fun getDate(timeZoneId: String): String {
        TODO("Not yet implemented")
    }

    override fun search(startHour: Int, endHour: Int, timeZoneString: List<String>): List<Int> {
        TODO("Not yet implemented")
    }

    fun formatDateTime(dateTime: LocalDateTime): String {
        val stringBuilder = StringBuilder()
        val minute = dateTime.minute
        var hour = dateTime.hour % 12
        if (hour == 0) hour = 12
        val amPm = if (dateTime.hour < 12) " am" else " pm"
        stringBuilder.append(hour.toString())
        stringBuilder.append(":")
        if (minute < 10) {
            stringBuilder.append('0')
        }
        stringBuilder.append(minute.toString())
        stringBuilder.append(amPm)
        return stringBuilder.toString()
    }
}