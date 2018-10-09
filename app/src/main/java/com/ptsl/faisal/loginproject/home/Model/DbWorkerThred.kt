package com.ptsl.faisal.loginproject.home.Model

import android.os.AsyncTask
import android.os.Handler
import android.os.HandlerThread

class DbWorkerThred(threadName: String): HandlerThread(threadName) {

    private  lateinit var mWorkerHandler :Handler

    override fun onLooperPrepared() {
        super.onLooperPrepared()

        mWorkerHandler= Handler(looper)
    }

    fun postTask(task: Runnable){
        mWorkerHandler.post(task)
    }
}