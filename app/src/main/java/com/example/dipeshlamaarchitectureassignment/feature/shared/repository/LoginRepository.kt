package com.example.dipeshlamaarchitectureassignment.feature.shared.repository

import com.example.dipeshlamaarchitectureassignment.feature.shared.model.response.LoginResponse
import com.example.dipeshlamaarchitectureassignment.network.RetrofitHelper
import io.reactivex.Single
import retrofit2.Response

class LoginRepository {

    fun userLogin (email: String, password: String) : Single <LoginResponse>{
        val loginResponse = RetrofitHelper.getLoginApiService().userLogin(email, password)
        return loginResponse
    }
}