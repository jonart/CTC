package ru.evgeniy.ctc.delegate.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import ru.evgeniy.ctc.ItemClick
import ru.evgeniy.ctc.models.Item

class ItemAdapters(itemClick: ItemClick) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val delegates = listOf(MoveAdapterDelegate(itemClick), EventAdapterDelegate(itemClick), NoticeAdapterDelegate(itemClick))

    var items:List<Item> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int): RecyclerView.ViewHolder {
        return delegates[type].onCreateViewHolder(viewGroup)
    }

    override fun getItemViewType(position: Int): Int {
        return delegates.indexOfFirst { it.isForViewType(items,position) }
    }

    override fun getItemCount():Int = items.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        delegates[viewHolder.itemViewType].onBindViewHolder(viewHolder, items, position)
    }

}
