package ru.evgeniy.ctc.models

import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

class TimeInterval(private val from: Date, private val to: Date) : Serializable {
    companion object {
        private val FORMATTER = SimpleDateFormat("HH:mm", Locale.ENGLISH)
    }

    override fun toString(): String {
        val dif = to.time - from.time
        return FORMATTER.format(dif)
    }
}
