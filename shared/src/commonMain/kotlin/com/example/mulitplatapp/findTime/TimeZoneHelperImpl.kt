package com.example.mulitplatapp.findTime

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
}