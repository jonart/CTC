package ru.evgeniy.ctc.models

import java.text.SimpleDateFormat
import java.time.temporal.ChronoUnit
import java.util.*

class TimeInterval(private val from: Date, private val to: Date) {
    companion object {
        private val FORMATTER = SimpleDateFormat("HH:mm", Locale.ENGLISH)
    }

    override fun toString(): String {
        val dif = to.time - from.time

        return FORMATTER.format(dif)
    }
}
