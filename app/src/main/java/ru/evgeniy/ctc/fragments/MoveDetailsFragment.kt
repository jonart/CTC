package ru.evgeniy.ctc.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_move_details.*

import ru.evgeniy.ctc.R
import ru.evgeniy.ctc.UtilDate
import ru.evgeniy.ctc.models.Move


class MoveDetailsFragment : Fragment() {

    companion object {
        private const val MOVE_KEY = "MOVE_KEY"
        fun newInstance(move: Move): Fragment {
            val bundle = Bundle()
            bundle.putParcelable(MOVE_KEY, move)
            return MoveDetailsFragment().apply { arguments = bundle }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_move_details, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = getString(R.string.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val move = arguments?.getParcelable<Move>(MOVE_KEY)!!
        from.text = move.fromPlace
        to.text = move.toPlace
        timeInAir.text = move.estimateTime.toString()
    }

}
