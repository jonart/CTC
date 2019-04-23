package ru.evgeniy.ctc.models

import ru.evgeniy.ctc.UtilDate
import ru.evgeniy.ctc.UtilRandomCity
import java.lang.IllegalStateException
import java.util.*

sealed class Item
data class Move(val fromPlace: String, val toPlace: String, var estimateTime: TimeInterval) : Item(){
    companion object{
        fun createRandInstance():Move {
            return Move(UtilRandomCity.randCity(),UtilRandomCity.randCity(), TimeInterval(Date(),UtilDate.increaseHour(Date())))
        }
    }
    override fun toString(): String {
        return "Из: $fromPlace , В: $toPlace, Время в воздухе:$estimateTime"
    }
}
data class Notice(val flightDate: Date, val gate: String) : Item(){
    companion object{
        fun createRandInstance():Notice {
            return Notice(Date(),('A'..'F').random().toString() + (1..10).random())
        }
    }
    override fun toString(): String {

        return "Дата: ${UtilDate.getDate(flightDate)}, Выход: $gate"
    }
}
data class Event(val startTime: Date, val endTime: Date, val name: String) : Item(){
    companion object{
        fun createRandInstance():Event {
            return Event(Date(),UtilDate.increaseHour(Date()),('A'..'Z').random() + (1..999).random().toString())
        }
    }

    override fun toString(): String {
        return "Вылет: ${UtilDate.getDate(startTime)}, Прилёт: ${UtilDate.getDate(endTime)}, Рейс: $name"
    }
}

fun createRandInstance():Item{
    return when((1..3).random()){
        1 -> Move.createRandInstance()
        2 -> Notice.createRandInstance()
        3 -> Event.createRandInstance()
        else ->  throw IllegalStateException()
    }
}