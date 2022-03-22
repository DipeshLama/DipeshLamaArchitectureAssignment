package com.example.dipeshlamaarchitectureassignment.feature.shared.repository

import com.example.dipeshlamaarchitectureassignment.feature.shared.model.response.MovieResponse
import com.example.dipeshlamaarchitectureassignment.network.RetrofitHelper
import io.reactivex.Single

class MovieRepository {

    fun getMoviesFromApi () : Single<ArrayList<MovieResponse>>{
        val movies = RetrofitHelper.getMovieApiService().getMovieList()
        return movies
    }
}