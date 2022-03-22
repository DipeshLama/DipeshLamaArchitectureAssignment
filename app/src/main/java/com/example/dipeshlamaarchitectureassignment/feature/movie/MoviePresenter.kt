package com.example.dipeshlamaarchitectureassignment.feature.movie

import android.annotation.SuppressLint
import com.example.dipeshlamaarchitectureassignment.feature.shared.model.response.MovieResponse
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MoviePresenter : MvpBasePresenter<MovieView>() {
    private var movieInteracter: MovieInteracter? = null

    override fun attachView(view: MovieView) {
        super.attachView(view)
        movieInteracter = MovieInteracter()
    }

    override fun detachView() {
        movieInteracter = null
        super.detachView()
    }

    @SuppressLint("CheckResult")
    fun getMovies (){
        movieInteracter?.getMovie()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({
                handleSuccess(it)
            },{
                handleFailure(it.localizedMessage)
            })
    }

    private fun handleSuccess (movie : ArrayList<MovieResponse>){
        ifViewAttached { view ->
            view.moviesList(movie)
        }
    }

    private fun handleFailure (localizedMessage : String?){
        ifViewAttached { view ->
            view.showError(localizedMessage)
        }
    }
}