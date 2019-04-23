package ru.evgeniy.ctc.activity

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.evgeniy.ctc.R
import ru.evgeniy.ctc.delegate.ItemAdapters
import ru.evgeniy.ctc.models.Item
import ru.evgeniy.ctc.models.Move
import ru.evgeniy.ctc.models.TimeInterval
import ru.evgeniy.ctc.models.createRandInstance
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = LinearLayoutManager(this)
        val adapter = ItemAdapters{AlertDialog.Builder(this).setMessage(it.toString()).show()}
        //(10..100).random()
        adapter.items = getFlights()
        recycler.adapter = adapter

    }

    private fun getFlights(): List<Item> {
        val flights: MutableList<Item> = mutableListOf()



        for(i in 10..100){
            flights.add(createRandInstance())
        }

//        flights.add(Move("Asd","Asd", TimeInterval(Date(),Date())))
//        flights.add(Move("Asd","Asd", TimeInterval(Date(),Date())))
//        flights.add(Move("Asd","Asd", TimeInterval(Date(),Date())))
//        flights.add(Move("Asd","Asd", TimeInterval(Date(),Date())))
//        flights.add(Move("Asd","Asd", TimeInterval(Date(),Date())))
//        flights.add(Move("Asd","Asd", TimeInterval(Date(),Date())))
        return flights
    }
}
