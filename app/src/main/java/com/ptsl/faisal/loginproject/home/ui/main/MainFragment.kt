package com.ptsl.faisal.loginproject.home.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ptsl.faisal.loginproject.R
import com.ptsl.faisal.loginproject.home.Model.DbWorkerThred
import com.ptsl.faisal.loginproject.home.Model.NoteItem
import com.ptsl.faisal.loginproject.home.Model.NoteItemDataBase


class MainFragment : Fragment() {

    private var mRoomDB:NoteItemDataBase?=null

    private lateinit var mDbWorkerThred: DbWorkerThred

    private val mUIHandler=Handler()

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        mDbWorkerThred= DbWorkerThred("dbWorkerThread")
        mDbWorkerThred.start()



        mRoomDB= NoteItemDataBase.getInstance(this.activity!!)

        insertNoteDataInDb(NoteItem(4545,"Dime","Hello","2154563"))
        return inflater.inflate(R.layout.main_fragment, container, false)
    }


    private fun insertNoteDataInDb(noteData: NoteItem) {
        val task = Runnable { mRoomDB?.noteItemDataDao()?.insert(noteData) }
        mDbWorkerThred.postTask(task)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
