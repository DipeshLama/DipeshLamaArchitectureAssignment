package com.example.dipeshlamaarchitectureassignment.feature.shared.viewholder

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dipeshlamaarchitectureassignment.R
import com.example.dipeshlamaarchitectureassignment.feature.shared.model.response.MovieResponse

class MovieViewHolder(var context : Context, view: View) : RecyclerView.ViewHolder(view) {
    val movieName = view.findViewById<TextView>(R.id.txtMovieName)
    val poster = view.findViewById<ImageView>(R.id.imgMoviePoster)
    val releaseYear = view.findViewById<TextView>(R.id.txtReleaseYear)

    fun bind (movie : MovieResponse){
        movieName.text = movie.name
        releaseYear.text= movie.year
        Glide.with(context).load(movie.poster).into(poster)
    }
}