package com.sevgiaykir.e_commerceandroidapp.viewmodel

import androidx.lifecycle.ViewModel
import com.sevgiaykir.e_commerceandroidapp.repo.ProductsDAORepository
import com.sevgiaykir.e_commerceandroidapp.retrofit.ProductsDAOInterface

class ProductDetailsPageViewModel: ViewModel() {

    val pdaor= ProductsDAORepository()

    fun updateCart(id:Int, sepet_durum:Int) {
    }
}