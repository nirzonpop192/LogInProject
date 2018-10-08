package com.ptsl.faisal.loginproject.login.View

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ptsl.faisal.loginproject.R
import com.ptsl.faisal.loginproject.databinding.ActivityMainBinding
import com.ptsl.faisal.loginproject.login.Interface.LoginResultCallBack
import com.ptsl.faisal.loginproject.login.ViewModel.LoginViewModelFactory
import com.ptsl.faisal.loginproject.login.ViewModel.LoginViewmodel
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity(),LoginResultCallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val activityMainBinding=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        activityMainBinding.viewModel=ViewModelProviders.of(this,LoginViewModelFactory(this))
                .get(LoginViewmodel::class.java)
    }

    override fun onSuccess(message: String) {
        Toasty.success(this, message).show()
    }

    override fun onError(message: String) {
        Toasty.error(this,message).show()
    }
}
