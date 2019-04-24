package ru.evgeniy.ctc.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_event_details.*

import ru.evgeniy.ctc.R
import ru.evgeniy.ctc.UtilDate
import ru.evgeniy.ctc.models.Event

class EventDetailsFragment : Fragment() {

    companion object {
        private const val EVENT_KEY = "EVENT_KEY"
        fun newInstance(event: Event): Fragment {
            val bundle = Bundle()
            bundle.putParcelable(EVENT_KEY, event)
            return EventDetailsFragment().apply { arguments = bundle }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_event_details, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val event = arguments?.getParcelable<Event>(EVENT_KEY)!!
        startTime.text = UtilDate.formatDate(event.startTime)
        endTime.text = UtilDate.formatDate(event.endTime)
        flight.text = event.name
    }
}
