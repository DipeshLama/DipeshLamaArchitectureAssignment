package com.example.dipeshlamaarchitectureassignment.feature.login

import android.annotation.SuppressLint
import com.example.dipeshlamaarchitectureassignment.feature.shared.model.response.LoginResponse
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginPresenter : MvpBasePresenter<LoginView> (){
    private var loginInteractor : LoginInteractor?=null

    override fun attachView(view: LoginView) {
        super.attachView(view)
        loginInteractor = LoginInteractor()
    }

    override fun detachView() {
        loginInteractor = null
        super.detachView()
    }

    @SuppressLint("CheckResult")
    fun checkUserLogin (email:String, password: String) {
        loginInteractor?.checkUser(email, password)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({
                handleSuccess(it)
            },{
                handleFailure(it.localizedMessage)
            })
    }

    private fun handleSuccess(loginResponse : LoginResponse?){
        ifViewAttached {view ->
            view.loginUser(loginResponse)
        }
    }

    private fun handleFailure(localizedMessage : String?){
        ifViewAttached { view ->
            view.showMessage(localizedMessage)
        }
    }
}