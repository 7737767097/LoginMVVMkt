package com.gzeinnumer.loginmvvmkt.interfaceCallback

//todo 6
interface LoginResultCallBack {
    fun onSuccess(message: String)
    fun onError(message: String)
}