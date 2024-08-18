package com.example.mulitplatapp.findTime

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.math.abs

class TimeZoneHelperImpl: TimeZoneHelper {

    override fun getTimeZoneStrings(): List<String> {
        return TimeZone.availableZoneIds.sorted()
    }

    override fun currentTime(): String {
        val currentMoment: Instant = Clock.System.now()
        val dateTime: LocalDateTime = currentMoment.toLocalDateTime(TimeZone.currentSystemDefault())
        return formatDateTime(dateTime)
    }

    override fun currentTimeZone(): String {
        val currentTimeZone = TimeZone.currentSystemDefault()
        return currentTimeZone.toString()
    }

    override fun hoursFromTimeZone(otherTimeZoneId: String): Double {
        val currentTimeZone = TimeZone.currentSystemDefault()
        val currentUTCInstant: Instant = Clock.System.now()
        // Date time in other timezone
        val otherTimeZone = TimeZone.of(otherTimeZoneId)
        val currentDateTime: LocalDateTime = currentUTCInstant.toLocalDateTime(currentTimeZone)
        val currentOtherDateTime: LocalDateTime = currentUTCInstant.toLocalDateTime(otherTimeZone)
        return abs((currentDateTime.hour - currentOtherDateTime.hour) * 1.0)
    }

    override fun getTime(timeZoneId: String): String {
      val timeZone = TimeZone.of(timeZoneId)
        val currentMoment: Instant = Clock.System.now()
        val dateTime: LocalDateTime = currentMoment.toLocalDateTime(timeZone)
        return formatDateTime(dateTime)
    }

    override fun getDate(timeZoneId: String): String {
        val timeZone = TimeZone.of(timeZoneId)
        val currentMoment: Instant = Clock.System.now()
        val dateTime: LocalDateTime = currentMoment.toLocalDateTime(timeZone)
        return "${dateTime.dayOfWeek.name.lowercase().replaceFirstChar { it.uppercase() }}, " +
                "${dateTime.month.name.lowercase().replaceFirstChar { it.uppercase() }} ${dateTime.date.dayOfMonth}"
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