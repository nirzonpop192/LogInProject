package com.ptsl.faisal.loginproject.login.View

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ptsl.faisal.loginproject.R
import com.ptsl.faisal.loginproject.home.HomeActivity
import com.ptsl.faisal.loginproject.login.Interface.LoginResultCallBack
import com.ptsl.faisal.loginproject.login.ViewModel.LoginViewModel
import com.ptsl.faisal.loginproject.login.ViewModel.LoginViewModelFactory
import es.dmoral.toasty.Toasty
import android.R.attr.data
import com.ptsl.faisal.loginproject.R.id.container
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import com.ptsl.faisal.loginproject.databinding.FragLoginBinding
import com.ptsl.faisal.loginproject.home.ui.main.HomeFragment
import com.ptsl.faisal.loginproject.replaceFragment


class LoginFragment : Fragment(), LoginResultCallBack {

    private lateinit var viewModel: LoginViewModel

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val binding:FragLoginBinding = DataBindingUtil.inflate<FragLoginBinding>(inflater, R.layout.frag_login, container,false)
        var rowView: View = binding.root

        binding.viewModel = ViewModelProviders.of(this, LoginViewModelFactory(this)).get(LoginViewModel::class.java)
        return rowView
    }



    override fun onSuccess(message: String) {
        Toasty.success(activity!!, message).show()

        replaceFragment(HomeFragment.newInstance(), R.id.container,"HomeFragment")

    }

    override fun onError(message: String) {
        Toasty.error(activity!!, message).show()
    }


}