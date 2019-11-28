package com.gzeinnumer.loginmvvmkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.gzeinnumer.loginmvvmkt.databinding.ActivityMainBinding
import com.gzeinnumer.loginmvvmkt.interfaceCallback.LoginResultCallBack
import com.gzeinnumer.loginmvvmkt.viewModel.LoginViewModel
import com.gzeinnumer.loginmvvmkt.viewModel.LoginViewModelFactory
import es.dmoral.toasty.Toasty

//todo 12
class MainActivity : AppCompatActivity(), LoginResultCallBack {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //todo 10
        //rebuild app

        //todo 11
        //setContentView(R.layout.activity_main)

        val activityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(
                this,
                R.layout.activity_main)
        activityMainBinding.viewModel =
            ViewModelProviders.of(this,
            LoginViewModelFactory(this))
            .get(LoginViewModel::class.java)
    }

    //todo 13
    override fun onSuccess(message: String) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show()
    }
}
