package com.example.dipeshlamaarchitectureassignment.feature.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dipeshlamaarchitectureassignment.R
import com.example.dipeshlamaarchitectureassignment.feature.shared.adapter.MovieAdapter
import com.example.dipeshlamaarchitectureassignment.feature.shared.model.response.MovieResponse
import com.google.android.material.snackbar.Snackbar
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import kotlinx.android.synthetic.main.activity_movielist.*

class MovieListActivity : MvpActivity<MovieView,MoviePresenter>(),MovieView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movielist)
        initView()
    }

    override fun createPresenter(): MoviePresenter {
        return MoviePresenter()
    }

    override fun moviesList(movies: ArrayList<MovieResponse>) {
        populateRecyclerView(movies)
    }

    private fun populateRecyclerView (list : ArrayList<MovieResponse>){
        val adapter = MovieAdapter(this,list)
        ryvMovieList.adapter = adapter
//        adapter.notifyDataSetChanged()
    }

    override fun showError(localizedMessage: String?) {
        Snackbar.make(constraint_movie_list, localizedMessage.toString(),Snackbar.LENGTH_LONG).show()
    }

    private fun initView (){
        ryvMovieList.layoutManager = LinearLayoutManager(this)
        presenter.getMovies()
    }

}