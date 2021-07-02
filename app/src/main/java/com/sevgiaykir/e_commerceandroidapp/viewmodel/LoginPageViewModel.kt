package com.sevgiaykir.e_commerceandroidapp.viewmodel

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sevgiaykir.e_commerceandroidapp.entity.Users
import com.sevgiaykir.e_commerceandroidapp.repo.UsersDAORepository

class LoginPageViewModel:ViewModel() {

    val udaor=UsersDAORepository()
    var deger=MutableLiveData<Int>()
    var user=MutableLiveData<List<Users>>()

    //for validation
    val email=MutableLiveData<String>()
    val password=MutableLiveData<String>()

    init{
        deger=udaor.bringValue()
        user=udaor.bringUserInfo()
    }

    fun login(email:String, password:String){
        udaor.searchUser(email,password)
    }
}