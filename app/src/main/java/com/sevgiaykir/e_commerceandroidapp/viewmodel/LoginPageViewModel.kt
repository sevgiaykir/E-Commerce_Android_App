package com.sevgiaykir.e_commerceandroidapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sevgiaykir.e_commerceandroidapp.repo.UsersDAORepository

class LoginPageViewModel:ViewModel() {

    val udaor=UsersDAORepository()
    var deger=MutableLiveData<Int>()

    init{
        deger=udaor.bringValue()
    }

    fun login(email:String, password:String){
        udaor.searchUser(email,password)

    }
}