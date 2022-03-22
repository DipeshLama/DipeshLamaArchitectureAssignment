package com.example.dipeshlamaarchitectureassignment.network

import com.example.dipeshlamaarchitectureassignment.feature.shared.model.response.MovieResponse
import com.example.dipeshlamaarchitectureassignment.utils.constants.ApiConstants
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {
    private var movieApi : MovieApiService? = null
    private var loginApi : LoginApiService? = null

    private val gson = GsonBuilder().setLenient().create()

    private val retrofit : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(ApiConstants.BASE_URL)
        .client(getOkHttpClient())
        .build()

    private fun getOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
        return okHttpClient.build()
    }

    fun getMovieApiService() : MovieApiService {
        if(movieApi == null) {
            movieApi = retrofit.create(MovieApiService::class.java)
        }
        return movieApi ?: retrofit.create(MovieApiService::class.java)
    }

    fun getLoginApiService () : LoginApiService{
        if(loginApi == null){
            loginApi = retrofit.create(LoginApiService::class.java )
        }
        return loginApi ?: retrofit.create(LoginApiService::class.java)
    }
}