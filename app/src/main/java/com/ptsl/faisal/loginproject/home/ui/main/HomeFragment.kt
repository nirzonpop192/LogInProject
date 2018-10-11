package com.ptsl.faisal.loginproject.home.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ptsl.faisal.loginproject.R
import com.ptsl.faisal.loginproject.home.Model.DbWorkerThread
import com.ptsl.faisal.loginproject.home.Model.NoteItem
import com.ptsl.faisal.loginproject.home.Model.NoteItemDataBase
import com.ptsl.faisal.loginproject.home.ViewModel.HomeViewModel


class HomeFragment : Fragment() {

    private var mRoomDB:NoteItemDataBase?=null

    private lateinit var mDbWorkerThread: DbWorkerThread

    private val mUIHandler=Handler()

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        mDbWorkerThread= DbWorkerThread("dbWorkerThread")
        mDbWorkerThread.start()



        mRoomDB= NoteItemDataBase.getInstance(this.activity!!)


        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        insertNoteDataInDb(NoteItem(4545,"Dime","Hello","2154563"))
    }


    private fun insertNoteDataInDb(noteData: NoteItem) {
        val task = Runnable { mRoomDB?.noteItemDataDao()?.insert(noteData) }
        mDbWorkerThread.postTask(task)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

    }

}
