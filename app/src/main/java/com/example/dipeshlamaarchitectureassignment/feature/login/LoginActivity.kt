package com.example.dipeshlamaarchitectureassignment.feature.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.dipeshlamaarchitectureassignment.R
import com.example.dipeshlamaarchitectureassignment.feature.movie.MovieListActivity
import com.example.dipeshlamaarchitectureassignment.feature.shared.model.response.LoginResponse
import com.example.dipeshlamaarchitectureassignment.utils.constants.ErrorConstants
import com.google.android.material.snackbar.Snackbar
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : MvpActivity<LoginView,LoginPresenter>(),LoginView ,View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initListener()
    }

    private fun initListener (){
        btnLogin.setOnClickListener(this)
    }

    private fun checkLogin (){
        val email = edtEmail.text.toString()
        val password = edtPassword.text.toString()
        presenter.checkUserLogin(email,password)
    }

    //Override functions

    override fun createPresenter(): LoginPresenter {
        return LoginPresenter()
    }

    override fun loginUser(success: LoginResponse?) {
        if(success?.success == true){
            startActivity(Intent(this, MovieListActivity::class.java))
            finish()
        }
        else{
            Snackbar.make(login_activity,ErrorConstants.loginErrorMessage,Snackbar.LENGTH_LONG).show()
        }
    }

    override fun showMessage(localizedMessage: String?) {
        Snackbar.make(login_activity,localizedMessage.toString(), Snackbar.LENGTH_LONG).show()
    }

    override fun onClick(view: View?) {
        when(view){
            btnLogin ->{
                checkLogin()
            }
        }
    }
}