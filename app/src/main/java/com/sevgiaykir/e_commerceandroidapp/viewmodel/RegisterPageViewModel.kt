package com.sevgiaykir.e_commerceandroidapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.sevgiaykir.e_commerceandroidapp.repo.UsersDAORepository

class RegisterPageViewModel: ViewModel()  {

    val udaor= UsersDAORepository()

    fun register(name_surname:String, email:String, phoneNo:String, password:String){
        udaor.insertUser(name_surname,email,phoneNo,password)
    }
}