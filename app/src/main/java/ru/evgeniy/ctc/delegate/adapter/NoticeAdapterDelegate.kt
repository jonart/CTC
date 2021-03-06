package ru.evgeniy.ctc.delegate.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.evgeniy.ctc.ItemClick
import ru.evgeniy.ctc.R
import ru.evgeniy.ctc.UtilDate
import ru.evgeniy.ctc.models.Item
import ru.evgeniy.ctc.models.Notice

class NoticeAdapterDelegate(private val itemClick: ItemClick) : ItemAdapterDelegate() {
    override fun onCreateViewHolder(viewGroup: ViewGroup): RecyclerView.ViewHolder {
        return NoticeViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_notice, viewGroup, false))
    }

    override fun isForViewType(items: List<Item>, position: Int): Boolean = items[position] is Notice

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, items: List<Item>, position: Int) {
        val vh = holder as NoticeViewHolder
        val notice = items[position] as Notice
        vh.flightDate.text = UtilDate.formatDate(notice.flightDate)
        vh.gate.text = notice.gate
        vh.itemView.setOnClickListener {
            itemClick.onItemClick(notice)
        }
    }

    private class NoticeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val flightDate: TextView = itemView.findViewById(R.id.flight_date)
        val gate: TextView = itemView.findViewById(R.id.flight_gate)
    }
}