package com.sevgiaykir.e_commerceandroidapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sevgiaykir.e_commerceandroidapp.entity.Products
import com.sevgiaykir.e_commerceandroidapp.repo.ProductsDAORepository

class CartPageViewModel:ViewModel() {

    var cartProdList=MutableLiveData<List<Products>>()
    val pdaor=ProductsDAORepository()

    init {
        loadCartProduct()
        cartProdList=pdaor.bringCartProd()
    }

    fun loadCartProduct() {
        pdaor.searchCartProd()
    }

    fun removeCartProduct(id:Int,cartSituation:Int) {
        pdaor.updateCartSituation(id,cartSituation)
    }

}