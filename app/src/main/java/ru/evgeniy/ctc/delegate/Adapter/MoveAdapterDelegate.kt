package ru.evgeniy.ctc.delegate.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.evgeniy.ctc.R
import ru.evgeniy.ctc.models.Item
import ru.evgeniy.ctc.models.Move

class MoveAdapterDelegate() : ItemAdapterDelegate() {

    override fun onCreateViewHolder(viewGroup: ViewGroup): RecyclerView.ViewHolder {
        return MoveViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_move, viewGroup, false))
    }

    override fun isForViewType(items: List<Item>, position: Int): Boolean = items[position] is Move

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, items: List<Item>, position: Int) {
        val vh = holder as MoveViewHolder
        val move = items[position] as Move
        vh.from.text = move.fromPlace
        vh.to.text = move.toPlace
        vh.interval.text = move.estimateTime.toString()
    }

    private class MoveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val from: TextView = itemView.findViewById(R.id.tv_from)
        val to: TextView = itemView.findViewById(R.id.tv_to)
        val interval: TextView = itemView.findViewById(R.id.tv_interval)
    }
}