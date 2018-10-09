package com.ptsl.faisal.loginproject.login.View

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ptsl.faisal.loginproject.R
import com.ptsl.faisal.loginproject.databinding.ActivityMainBinding
import com.ptsl.faisal.loginproject.home.MainActivity
import com.ptsl.faisal.loginproject.login.Interface.LoginResultCallBack
import com.ptsl.faisal.loginproject.login.ViewModel.LoginViewModelFactory
import com.ptsl.faisal.loginproject.login.ViewModel.LoginViewModel
import es.dmoral.toasty.Toasty

class LoginActivity : AppCompatActivity(), LoginResultCallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProviders.of(this, LoginViewModelFactory(this))
                .get(LoginViewModel::class.java)

        // todo :Convert it into fragment
    }

    override fun onSuccess(message: String) {
        Toasty.success(this, message).show()
//        MainActivity.open(this)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onError(message: String) {
        Toasty.error(this, message).show()
    }
}
