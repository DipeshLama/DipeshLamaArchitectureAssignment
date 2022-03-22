package com.example.dipeshlamaarchitectureassignment.network

import com.example.dipeshlamaarchitectureassignment.feature.shared.model.response.LoginResponse
import com.example.dipeshlamaarchitectureassignment.utils.constants.ApiConstants
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Path

interface LoginApiService {

    @POST(ApiConstants.login)
    fun userLogin(
        @Path("email") email : String,
        @Path("password") password: String
    ) : Single<LoginResponse>
}