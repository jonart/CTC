package ru.evgeniy.ctc.models

import android.os.Parcel
import android.os.Parcelable
import ru.evgeniy.ctc.UtilDate
import java.util.*

class Event(val startTime: Date, val endTime: Date, val name: String) : Item {
    companion object CREATOR : Parcelable.Creator<Event> {
        override fun createFromParcel(parcel: Parcel): Event {
            return Event(parcel)
        }

        override fun newArray(size: Int): Array<Event?> {
            return arrayOfNulls(size)
        }

        fun createRandInstance(): Event {
            return Event(Date(), UtilDate.increaseRandomTime(Date()), ('A'..'Z').random() + (1..999).random().toString())
        }
    }

    constructor(parcel: Parcel) : this(
            parcel.readSerializable() as Date,
            parcel.readSerializable() as Date,
            parcel.readString())

    override fun toString(): String {
        return "Вылет: ${UtilDate.formatDate(startTime)}, Прилёт: ${UtilDate.formatDate(endTime)}, Рейс: $name"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeSerializable(startTime)
        parcel.writeSerializable(endTime)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }
}