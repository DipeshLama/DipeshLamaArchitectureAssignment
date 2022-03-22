package com.example.dipeshlamaarchitectureassignment.feature.login

import com.example.dipeshlamaarchitectureassignment.feature.shared.model.response.LoginResponse
import com.hannesdorfmann.mosby3.mvp.MvpView

interface LoginView : MvpView {

    fun loginUser (success: LoginResponse?)
    fun showMessage (localizedMessage : String?)
}