package com.ptsl.faisal.loginproject.home

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ptsl.faisal.loginproject.R
import com.ptsl.faisal.loginproject.home.ui.main.MainFragment


class MainActivity : AppCompatActivity() {


/*
        // generate null point exception
    companion object {
        fun open(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            val activity = MainActivity()
            activity.startActivity(intent)
        }
    }
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }

    }

}
