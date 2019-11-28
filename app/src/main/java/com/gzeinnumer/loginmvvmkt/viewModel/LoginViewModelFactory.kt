package com.gzeinnumer.loginmvvmkt.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gzeinnumer.loginmvvmkt.interfaceCallback.LoginResultCallBack
import java.lang.Class as Class

//todo 8
//https://github.com/syntaxxxxx/MiniWorkshopAEJ/blob/final/app/src/main/java/com/example/mvvm/ui/ViewModelFactory.kt
class LoginViewModelFactory(private val listener: LoginResultCallBack): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(listener) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}