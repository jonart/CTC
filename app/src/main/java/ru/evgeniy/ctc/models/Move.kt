package ru.evgeniy.ctc.models

import android.os.Parcel
import android.os.Parcelable
import ru.evgeniy.ctc.UtilDate
import ru.evgeniy.ctc.UtilRandomCity
import java.util.*

class Move(val fromPlace: String, val toPlace: String, val estimateTime: TimeInterval) : Item {

    companion object CREATOR : Parcelable.Creator<Move> {
        override fun createFromParcel(parcel: Parcel): Move {
            return Move(parcel)
        }

        override fun newArray(size: Int): Array<Move?> {
            return arrayOfNulls(size)
        }

        fun createRandInstance(): Move {
            return Move(UtilRandomCity.randCity(), UtilRandomCity.randCity(), TimeInterval(Date(),
                    UtilDate.increaseRandomTime(Date())))
        }
    }

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readSerializable() as TimeInterval)

    override fun toString(): String {
        return "Из: $fromPlace , В: $toPlace, Время в воздухе:$estimateTime"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fromPlace)
        parcel.writeString(toPlace)
        parcel.writeSerializable(estimateTime)
    }

    override fun describeContents(): Int {
        return 0
    }
}