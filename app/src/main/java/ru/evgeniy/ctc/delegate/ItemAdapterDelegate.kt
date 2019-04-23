package ru.evgeniy.ctc.delegate

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.evgeniy.ctc.models.Item

abstract class ItemAdapterDelegate {

    abstract fun onBindViewHolder(holder: RecyclerView.ViewHolder, items: List<Item>, position: Int)
    fun onCreateViewHolder(viewGroup: ViewGroup): RecyclerView.ViewHolder {
        return onCreateViewHolder(viewGroup, LayoutInflater.from(viewGroup.context))
    }

    protected abstract fun onCreateViewHolder(viewGroup: ViewGroup, inflater: LayoutInflater): RecyclerView.ViewHolder
    abstract fun isForViewType(items: List<Item>, position: Int): Boolean
}