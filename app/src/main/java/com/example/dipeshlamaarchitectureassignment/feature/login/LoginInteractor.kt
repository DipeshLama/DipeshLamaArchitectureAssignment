package com.example.dipeshlamaarchitectureassignment.feature.login

import com.example.dipeshlamaarchitectureassignment.feature.shared.repository.LoginRepository
import com.example.dipeshlamaarchitectureassignment.feature.shared.repository.MovieRepository

class LoginInteractor {

    val loginRepository = LoginRepository()
    fun checkUser (email: String, password: String) = loginRepository.userLogin(email,password)
}