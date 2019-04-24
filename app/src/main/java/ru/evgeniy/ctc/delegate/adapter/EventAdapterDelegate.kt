package ru.evgeniy.ctc.delegate.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.evgeniy.ctc.ItemClick
import ru.evgeniy.ctc.R
import ru.evgeniy.ctc.UtilDate
import ru.evgeniy.ctc.models.Event
import ru.evgeniy.ctc.models.Item

class EventAdapterDelegate(private val itemClick: ItemClick) : ItemAdapterDelegate() {

    override fun onCreateViewHolder(viewGroup: ViewGroup): RecyclerView.ViewHolder {
        return EventViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_event, viewGroup, false))
    }

    override fun isForViewType(items: List<Item>, position: Int): Boolean = items[position] is Event

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, items: List<Item>, position: Int) {
        val vh = holder as EventViewHolder
        val event = items[position] as Event
        vh.startTime.text = UtilDate.formatDate(event.startTime)
        vh.endTime.text = UtilDate.formatDate(event.endTime)
        vh.name.text = event.name
        vh.itemView.setOnClickListener {
            itemClick.onItemClick(event)
        }
    }

    private class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val startTime: TextView = itemView.findViewById(R.id.tv_startTime)
        val endTime: TextView = itemView.findViewById(R.id.tv_endTime)
        val name: TextView = itemView.findViewById(R.id.tv_name)
    }
}