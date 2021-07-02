package com.sevgiaykir.e_commerceandroidapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sevgiaykir.e_commerceandroidapp.repo.ProductsDAORepository
import com.sevgiaykir.e_commerceandroidapp.retrofit.ProductsDAOInterface

class ProductDetailsPageViewModel: ViewModel() {

    val pdaor= ProductsDAORepository()

    init {

    }

    fun updateCart(id:Int, cartSit:Int) {
    pdaor.updateCartSituation(id,cartSit)
        //sepet_durum=1 olacak ya da artacak
    }
}