package com.ptsl.faisal.loginproject


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ptsl.faisal.loginproject.login.View.LoginFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            /*supportFragmentManager.beginTransaction()
                    .replace(R.id.container, LoginFragment.newInstance())
                    .commitNow()*/
            replaceFragment(LoginFragment.newInstance(), R.id.container,"LoginFragment")
        }
    }


}

/*class MainActivity : AppCompatActivity(), LoginResultCallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProviders.of(this, LoginViewModelFactory(this))
                .get(LoginViewModel::class.java)


    }


}*/
