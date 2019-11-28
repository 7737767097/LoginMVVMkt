package com.gzeinnumer.loginmvvmkt.model

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import java.util.*
import java.util.regex.Pattern

//todo 5
data class User(var email: String, var password: String): BaseObservable(){
    val isDataValid: Boolean
    get() = (!TextUtils.isEmpty(email))
            && Patterns.EMAIL_ADDRESS.matcher(email).matches()
            && password.length > 6


    //todo 14
    fun validateData(): Int{
        if (TextUtils.isEmpty(email))
            return 0
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return 1
        else if(password.length<7)
            return 2
        else
            return -1
    }


}