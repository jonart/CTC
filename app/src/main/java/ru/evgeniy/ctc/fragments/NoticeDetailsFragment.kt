package ru.evgeniy.ctc.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_notice_details.*

import ru.evgeniy.ctc.R
import ru.evgeniy.ctc.UtilDate
import ru.evgeniy.ctc.models.Notice

class NoticeDetailsFragment : Fragment() {

    companion object {
        private const val NOTICE_KEY = "NOTICE_KEY"
        fun newInstance(notice: Notice): Fragment {
            val bundle = Bundle()
            bundle.putParcelable(NOTICE_KEY, notice)
            return NoticeDetailsFragment().apply { arguments = bundle }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notice_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val notice = arguments?.getParcelable<Notice>(NOTICE_KEY)!!
        gate.text = notice.gate
        date.text = UtilDate.formatDate(notice.flightDate)
    }
}
