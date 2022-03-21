package com.example.dipeshlamaarchitectureassignment.feature.shared.repository

import com.example.dipeshlamaarchitectureassignment.feature.shared.model.response.MovieResponse
import com.example.dipeshlamaarchitectureassignment.network.RetrofitHelper
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.operators.single.SingleToObservable
import io.reactivex.schedulers.Schedulers

class MovieRepository {

    fun getMoviesFromApi () : Single<ArrayList<MovieResponse>>{
        val movies = RetrofitHelper.getMovieApiService().getMovieList()
        return movies
    }
}