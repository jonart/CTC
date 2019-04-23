package ru.evgeniy.ctc.delegate.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.evgeniy.ctc.models.Item

abstract class ItemAdapterDelegate {

    abstract fun onBindViewHolder(holder: RecyclerView.ViewHolder, items: List<Item>, position: Int)
    abstract fun onCreateViewHolder(viewGroup: ViewGroup): RecyclerView.ViewHolder

    abstract fun isForViewType(items: List<Item>, position: Int): Boolean
}