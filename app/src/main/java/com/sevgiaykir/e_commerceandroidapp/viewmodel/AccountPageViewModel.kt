package com.sevgiaykir.e_commerceandroidapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sevgiaykir.e_commerceandroidapp.entity.Users
import com.sevgiaykir.e_commerceandroidapp.repo.UsersDAORepository

class AccountPageViewModel: ViewModel() {

    val udaor= UsersDAORepository()
    var user= MutableLiveData<List<Users>>()

    init{
        user=udaor.bringUsers()
    }
}