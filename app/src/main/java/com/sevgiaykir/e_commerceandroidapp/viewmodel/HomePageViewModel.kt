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
        pdaor.searchProd("cerentunay")
        /*
        val list=ArrayList<Products>()
        list.add(Products(1,"sevgi","ürün adıı","fiyat","açıklama","",0,0))
        list.add(Products(1,"sevgi","ürün adı2","fiyat2","açıklama","",0,0))

        prodList.value=list */
    }

    fun getInfo(id:Int){
        Log.e("Detaya Git","$id")
    }
}