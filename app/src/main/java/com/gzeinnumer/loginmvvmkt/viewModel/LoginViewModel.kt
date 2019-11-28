package com.gzeinnumer.loginmvvmkt.viewModel

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gzeinnumer.loginmvvmkt.interfaceCallback.LoginResultCallBack
import com.gzeinnumer.loginmvvmkt.model.User

//todo 7
class LoginViewModel(private val listener: LoginResultCallBack) : ViewModel() {
    private var user: User? = null

    init {
        this.user = User("","")
    }

    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                user?.email = s.toString()
            }
        }

    val passTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                user?.password = s.toString()
            }
        }

    fun onLoginCLicked(v: View){
//        if (user?.isDataValid!!)
//            listener.onSuccess("Login Success")
//        else
//            listener.onError("Login Error")
        //todo 15
        //ganti if di atas dengan ini
        when (user?.validateData()) {
            0 -> listener.onError("Email tidak boleh kosong")
            1 -> listener.onError("Email tidak valid")
            2 -> listener.onError("Password harus lebih dari 6 huruf")
            else -> listener.onSuccess("Login sukses")
        }
    }
}