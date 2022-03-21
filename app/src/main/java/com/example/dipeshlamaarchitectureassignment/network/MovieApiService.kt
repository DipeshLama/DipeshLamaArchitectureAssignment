package com.example.dipeshlamaarchitectureassignment.network

import com.example.dipeshlamaarchitectureassignment.feature.shared.model.response.MovieResponse
import com.example.dipeshlamaarchitectureassignment.utils.constants.ApiConstants
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.ArrayList

interface MovieApiService {

    @GET (ApiConstants.movie_list)
    fun getMovieList() :Single<ArrayList<MovieResponse>>
}