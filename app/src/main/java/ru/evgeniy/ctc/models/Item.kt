package ru.evgeniy.ctc.models

import android.os.Parcelable

interface Item : Parcelable {
    companion object {
        fun createRandInstance(): Item {
            return when ((1..3).random()) {
                1 -> Move.createRandInstance()
                2 -> Notice.createRandInstance()
                3 -> Event.createRandInstance()
                else -> throw IllegalStateException()
            }
        }
    }
}