package ru.evgeniy.ctc

object UtilRandomCity {
    private val city = arrayOf("San-Francisco","Los Angeles","Moscow","Индийская Агра","Акапулько",
            "Алжир","Амстердам","Берлин","Бангкок","Анкара","Афины","Барселона","Бостон","Будапешт",
            "Вена","Гавана")
    fun randCity():String{
        val rand = (0..15).random()
        return city[rand]
    }
}