package com.ptsl.faisal.loginproject.login.Model

import android.databinding.BaseObservable
import android.text.TextUtils
import android.util.Patterns


class User(private var email: String, private var password: String) : BaseObservable() {

    val isDataValid: Boolean
        get() = (!TextUtils.isEmpty(getEmail()))
                && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()
                && getPassword().length > 5

    private fun getEmail(): String {
        return email
    }

    private fun getPassword(): String {
        return password
    }

    public fun setEmail( email: String){
        this.email=email
    }
    public fun setPassword( password: String){
        this.password=password
    }
}