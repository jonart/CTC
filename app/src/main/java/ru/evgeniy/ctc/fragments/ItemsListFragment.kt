package ru.evgeniy.ctc.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_items_list.*
import ru.evgeniy.ctc.R
import ru.evgeniy.ctc.delegate.adapter.ItemAdapters
import ru.evgeniy.ctc.models.Item

class ItemsListFragment : Fragment() {
    companion object {
        private val gson = Gson()
        private lateinit var adapter: ItemAdapters
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_items_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ItemAdapters(requireFragmentManager())
        val rand = (10..100).random()
        adapter.items = generateItems(rand)
        retainInstance = true
    }

    private fun generateItems(count: Int): List<Item> {
        return (10..count).map { Item.createRandInstance() }
    }

}
