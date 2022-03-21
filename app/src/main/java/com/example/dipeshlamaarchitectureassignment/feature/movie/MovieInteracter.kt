package com.example.dipeshlamaarchitectureassignment.feature.movie

import com.example.dipeshlamaarchitectureassignment.feature.shared.repository.MovieRepository

class MovieInteracter {
    val movieRepository = MovieRepository()
    fun getMovie () = movieRepository.getMoviesFromApi()
}