package com.ptsl.faisal.loginproject.login.ViewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ptsl.faisal.loginproject.login.Interface.LoginResultCallBack

class LoginViewModelFactory(private val listener: LoginResultCallBack):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }
}