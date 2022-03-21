package com.example.dipeshlamaarchitectureassignment.feature.shared.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dipeshlamaarchitectureassignment.R
import com.example.dipeshlamaarchitectureassignment.feature.shared.model.response.MovieResponse
import com.example.dipeshlamaarchitectureassignment.feature.shared.viewholder.MovieViewHolder

class MovieAdapter (var context : Context, var movieList : ArrayList<MovieResponse>)
    : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_custom_list,parent,false)
        return MovieViewHolder(context, view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}