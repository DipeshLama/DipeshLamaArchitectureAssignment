package com.example.dipeshlamaarchitectureassignment.network

import com.example.dipeshlamaarchitectureassignment.feature.shared.model.response.LoginResponse
import com.example.dipeshlamaarchitectureassignment.utils.constants.ApiConstants
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface LoginApiService {


    @POST(ApiConstants.login)
    fun userLogin(
        @Query("email") email : String,
        @Query("password") password: String
    ) : Single<LoginResponse>


//    using @Path annotation
//    @POST(ApiConstants.login)
//    fun userLogin(
//        @Path("email") email : String,
//        @Path("password") password: String
//    ) : Single<LoginResponse>

}