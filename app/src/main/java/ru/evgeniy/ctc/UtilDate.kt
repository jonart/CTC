package ru.evgeniy.ctc

import java.text.SimpleDateFormat
import java.util.*


object UtilDate {

    private const val DISPLAY_TIMESTAMP_PATTERN = "dd-MMM HH:mm"

    fun getDate(inputDate: Date): String {

        val displayFormatter = SimpleDateFormat(DISPLAY_TIMESTAMP_PATTERN, Locale.ENGLISH)

        return displayFormatter.format(inputDate)
    }

    fun increaseHour(date:Date): Date{
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.HOUR,(1..14).random())
        calendar.add(Calendar.MINUTE,(1..59).random())
        return calendar.time
    }
}