package com.example.dipeshlamaarchitectureassignment.feature.movie

import com.example.dipeshlamaarchitectureassignment.feature.shared.model.response.MovieResponse
import com.hannesdorfmann.mosby3.mvp.MvpView

interface MovieView : MvpView {

    fun moviesList (movies : ArrayList<MovieResponse>)

    fun showError (localizedMessage : String?)
}