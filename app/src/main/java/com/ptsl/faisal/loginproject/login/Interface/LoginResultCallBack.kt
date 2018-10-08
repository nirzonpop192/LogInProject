package com.ptsl.faisal.loginproject.login.Interface

interface LoginResultCallBack {

    fun onSuccess(message:String)
    fun onError(message: String)
}