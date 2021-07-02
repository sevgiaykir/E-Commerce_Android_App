package com.sevgiaykir.e_commerceandroidapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sevgiaykir.e_commerceandroidapp.entity.Products
import com.sevgiaykir.e_commerceandroidapp.repo.ProductsDAORepository

class CampaignPageViewModel: ViewModel() {

    var campProdList= MutableLiveData<List<Products>>()
    val pdaor= ProductsDAORepository()

    init{
        loadCampaignProduct()
        campProdList=pdaor.bringDisProd()
    }

    fun loadCampaignProduct() {
        pdaor.searchDisProd()
    }
}