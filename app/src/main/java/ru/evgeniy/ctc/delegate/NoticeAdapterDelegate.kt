package ru.evgeniy.ctc.delegate

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.evgeniy.ctc.R
import ru.evgeniy.ctc.UtilDate
import ru.evgeniy.ctc.models.Item
import ru.evgeniy.ctc.models.Notice

class NoticeAdapterDelegate:ItemAdapterDelegate() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, inflater: LayoutInflater): RecyclerView.ViewHolder {
        return MoveViewHolder(inflater.inflate(R.layout.item_notice,viewGroup,false))
    }

    override fun isForViewType(items: List<Item>, position: Int): Boolean = items[position] is Notice

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, items: List<Item>, position: Int) {
        val vh = holder as MoveViewHolder
        val notice = items[position] as Notice
        vh.name.text = UtilDate.getDate(notice.flightDate)
        vh.gate.text = notice.gate
    }

    private class MoveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.flight_date)
        val gate: TextView = itemView.findViewById(R.id.flight_gate)
    }
}