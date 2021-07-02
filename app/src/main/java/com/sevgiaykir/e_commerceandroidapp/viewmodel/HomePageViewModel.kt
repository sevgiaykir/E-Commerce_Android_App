package com.sevgiaykir.e_commerceandroidapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sevgiaykir.e_commerceandroidapp.entity.Products
import com.sevgiaykir.e_commerceandroidapp.repo.ProductsDAORepository

class HomePageViewModel: ViewModel() {

    var prodList=MutableLiveData<List<Products>>()
    val pdaor=ProductsDAORepository()

    init{
        loadProduct()
        prodList=pdaor.bringProducts()
    }

    fun loadProduct() {
        pdaor.searchProd()
    }


    fun updateCart(id:Int, sepet_durum:Int) {
        pdaor.updateCartSituation(1,2)
    }

    fun getInfo(id:Int){
        Log.e("Detaya Git","$id")
    }
}