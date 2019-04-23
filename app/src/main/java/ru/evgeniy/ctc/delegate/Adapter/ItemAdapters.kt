package ru.evgeniy.ctc.delegate.Adapter

import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import ru.evgeniy.ctc.models.Item

class ItemAdapters(fragmentManager: FragmentManager) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val delegates = listOf(MoveAdapterDelegate(), EventAdapterDelegate(), NoticeAdapterDelegate(fragmentManager))

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
        delegates[getItemViewType(position)].onBindViewHolder(viewHolder,items,position)
    }

}
