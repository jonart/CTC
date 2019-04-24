package ru.evgeniy.ctc.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_items_list.*
import ru.evgeniy.ctc.ItemClick
import ru.evgeniy.ctc.R
import ru.evgeniy.ctc.delegate.adapter.ItemAdapters
import ru.evgeniy.ctc.models.Event
import ru.evgeniy.ctc.models.Item
import ru.evgeniy.ctc.models.Move
import ru.evgeniy.ctc.models.Notice
import java.lang.Exception
import java.lang.IllegalStateException

class ItemsListFragment : Fragment(), ItemClick {
    companion object {
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
        adapter = ItemAdapters(this)
        val rand = (10..100).random()
        adapter.items = generateItems(rand)
        retainInstance = true
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = getString(R.string.app_name)
    }

    private fun generateItems(count: Int): List<Item> {
        return (10..count).map { Item.createRandInstance() }
    }

    override fun onItemClick(item: Item) {
        val fragment: Fragment = when (item) {
            is Move -> MoveDetailsFragment.newInstance(item)
            is Event -> EventDetailsFragment.newInstance(item)
            is Notice -> NoticeDetailsFragment.newInstance(item)
            else -> throw Exception("Fragment was not Found")
        }
        goToFragment(fragment)
    }

    private fun goToFragment(fragment: Fragment) {
        requireFragmentManager().beginTransaction()
                .replace(R.id.root_frame, fragment)
                .addToBackStack(null)
                .commit()
    }
}
