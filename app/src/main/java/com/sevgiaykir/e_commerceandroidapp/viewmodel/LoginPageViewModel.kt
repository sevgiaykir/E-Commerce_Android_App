package com.sevgiaykir.e_commerceandroidapp.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sevgiaykir.e_commerceandroidapp.entity.Users
import com.sevgiaykir.e_commerceandroidapp.repo.UsersDAORepository
import kotlin.coroutines.coroutineContext

class LoginPageViewModel:ViewModel() {

    val udaor=UsersDAORepository()
    var deger=MutableLiveData<Int>()

    init{
        deger=udaor.degerGetir()
    }

    fun login(email:String, password:String){
        udaor.searchUser(email,password)



    }
}