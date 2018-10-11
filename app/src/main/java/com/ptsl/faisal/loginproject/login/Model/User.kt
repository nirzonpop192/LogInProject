package com.ptsl.faisal.loginproject.login.Model

import android.databinding.BaseObservable
import android.text.TextUtils
import android.util.Patterns


// These observable fields will update Views automatically
 class User(private var email: String, private var password: String) : BaseObservable() {

     companion object {
         const val EMPTY_EMAIL = 0
         const val NOT_EMAIL = 1
         const val EMPTY_PASSWORD = 2
         const val SUCCESSFUL_LOGIN = -1
     }


    // Login Button logic
    fun isDataValid(): Int {
        if (TextUtils.isEmpty(email))
            return EMPTY_EMAIL
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return NOT_EMAIL
        else if (getPassword().length < 6)
            return EMPTY_PASSWORD
        else
            return SUCCESSFUL_LOGIN
    }

    private fun getEmail(): String {
        return email
    }

    private fun getPassword(): String {
        return password
    }

    public fun setEmail(email: String) {
        this.email = email
    }

    public fun setPassword(password: String) {
        this.password = password
    }
}