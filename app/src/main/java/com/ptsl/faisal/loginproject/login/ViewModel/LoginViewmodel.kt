package com.ptsl.faisal.loginproject.login.ViewModel

import android.arch.lifecycle.ViewModel
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.ptsl.faisal.loginproject.login.Interface.LoginResultCallBack
import com.ptsl.faisal.loginproject.login.Model.User

class LoginViewmodel(private val listener: LoginResultCallBack) : ViewModel() {

    private val user: User

    init {
        this.user = User("", "")
    }

    /** create function set { @link User.Email} after user enter the text */

    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(text: Editable?) {
                user.setEmail(text.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        }

    /** create function set { @link User.password} after user enter the text */

    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(text: Editable?) {
                user.setPassword(text.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        }

    /** create function to process login button clicked*/

    fun onLoginBtnClick(view: View) {

        if (user.isDataValid)
            listener.onSuccess("Login Success")
        else
            listener.onError("Login Error")
    }

}