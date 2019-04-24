package ru.evgeniy.ctc.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ru.evgeniy.ctc.R
import ru.evgeniy.ctc.fragments.ItemsListFragment


class MainActivity : AppCompatActivity() {
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.root_frame, ItemsListFragment())
                    .commit()
        }
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount <= 0) {
            finish()
            return
        } else {
            fragmentManager.popBackStack()
        }
    }
}
