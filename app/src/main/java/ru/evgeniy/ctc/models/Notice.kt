package ru.evgeniy.ctc.models

import android.os.Parcel
import android.os.Parcelable
import ru.evgeniy.ctc.UtilDate
import java.util.*

class Notice(val flightDate: Date, val gate: String) : Item {
    companion object CREATOR : Parcelable.Creator<Notice> {
        override fun createFromParcel(parcel: Parcel): Notice {
            return Notice(parcel)
        }

        override fun newArray(size: Int): Array<Notice?> {
            return arrayOfNulls(size)
        }

        fun createRandInstance(): Notice {
            return Notice(Date(), ('A'..'F').random().toString() + (1..10).random())
        }
    }

    constructor(parcel: Parcel) : this(
            parcel.readSerializable() as Date,
            parcel.readString())

    override fun toString(): String {
        return "Дата: ${UtilDate.formatDate(flightDate)}, Выход: $gate"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeSerializable(flightDate)
        parcel.writeString(gate)
    }

    override fun describeContents(): Int {
        return 0
    }
}