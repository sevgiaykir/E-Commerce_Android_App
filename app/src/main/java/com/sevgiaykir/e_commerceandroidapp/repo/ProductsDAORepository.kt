package com.sevgiaykir.e_commerceandroidapp.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sevgiaykir.e_commerceandroidapp.entity.CRUDResponse
import com.sevgiaykir.e_commerceandroidapp.entity.Products
import com.sevgiaykir.e_commerceandroidapp.entity.ProductsResponse
import com.sevgiaykir.e_commerceandroidapp.retrofit.ApiUtils
import com.sevgiaykir.e_commerceandroidapp.retrofit.ProductsDAOInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsDAORepository {

    private val productList:MutableLiveData<List<Products>>
    private val pdaoi: ProductsDAOInterface

    private var cartValidate=MutableLiveData<Int>()
    private val cartProductList:MutableLiveData<List<Products>>

    private var discountSituation=MutableLiveData<Int>()
    private val disProductList:MutableLiveData<List<Products>>

    init{
        pdaoi=ApiUtils.getProductsDaoInterface()
        productList= MutableLiveData()
        disProductList= MutableLiveData()
        discountSituation=MutableLiveData()
        cartProductList= MutableLiveData()
        cartValidate= MutableLiveData()
    }


    fun bringProducts():MutableLiveData<List<Products>> {
        return productList
    }

    fun searchProd(){
        pdaoi.searchProduct("sevgiaykir").enqueue(object : Callback<ProductsResponse> {
            override fun onResponse(
                call: Call<ProductsResponse>?,
                response: Response<ProductsResponse>
            ) {
                val list=response.body().urunler
                productList.value=list

                for(p in list){
                    Log.e("*****","******")
                    Log.e("id", p.id.toString())
                    //Log.e("info1", p.satici_adi)
                    Log.e("ad", p.urun_adi)
                    Log.e("sepet", p.sepet_durum.toString())
                    Log.e("indirim", p.urun_indirimli_mi.toString())

                }
            }

            override fun onFailure(call: Call<ProductsResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }

    //ürün eklemek için
/*
    fun insertProd(satici_adi:String,urun_adi:String,urun_fiyat:String,urun_aciklama:String,urun_gorsel_url:String){
        pdaoi.insertProduct(satici_adi,urun_adi,urun_fiyat,urun_aciklama,urun_gorsel_url).enqueue(object:
            Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>) {
            }

            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    } */

    fun bringCartProd():MutableLiveData<List<Products>> {
        return cartProductList
    }

    fun updateCartSituation(id:Int,sepet_durum:Int) {
        pdaoi.updateCart(id,sepet_durum).enqueue(object: Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>) {
                cartValidate.value=response.body().success
                Log.e("Güncelleme Başarılı", response.body().success.toString())
                Log.e("Güncelleme Başarısız", response.body().message)
            }

            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {}
        })
    }

    fun searchCartProd(){
        pdaoi.searchProduct("sevgiaykir").enqueue(object : Callback<ProductsResponse> {
            override fun onResponse(
                call: Call<ProductsResponse>?,
                response: Response<ProductsResponse>
            ) {
                val list=response.body().urunler
                var arrayListCartProd= arrayListOf<Products>()

                for(p in list){
                    if(p.sepet_durum==1) {
                        arrayListCartProd.add(p)
                        Log.e("*****", "******")
                        Log.e("id", p.id.toString())
                        //Log.e("info1", p.satici_adi)
                        Log.e("ad", p.urun_adi)
                        Log.e("sepet", p.sepet_durum.toString())
                        Log.e("indirim", p.urun_indirimli_mi.toString())
                    }
                }
                cartProductList.value=arrayListCartProd
            }

            override fun onFailure(call: Call<ProductsResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }

    fun bringDisProd():MutableLiveData<List<Products>> {
        return disProductList
    }

    fun updateDiscountSituation(id:Int,urun_indirimli_mi:Int) {
        pdaoi.updateDiscount(id,urun_indirimli_mi).enqueue(object: Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>) {
                Log.e("Güncelleme Başarılı", response.body().success.toString())
                Log.e("Güncelleme Başarısız", response.body().message)
            }

            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {}
        })
    }

    fun searchDisProd(){
        pdaoi.searchProduct("sevgiaykir").enqueue(object : Callback<ProductsResponse> {
            override fun onResponse(
                call: Call<ProductsResponse>?,
                response: Response<ProductsResponse>
            ) {
                val list=response.body().urunler
                var arrayListDisProd= arrayListOf<Products>()

                for(p in list){
                    if(p.urun_indirimli_mi==1)
                    {
                        arrayListDisProd.add(p)
                        Log.e("*****","******")
                        Log.e("id", p.id.toString())
                        //Log.e("info1", p.satici_adi)
                        Log.e("ad", p.urun_adi)
                        Log.e("sepet", p.sepet_durum.toString())
                        Log.e("indirim", p.urun_indirimli_mi.toString())
                    }
                }
                disProductList.value=arrayListDisProd
            }

            override fun onFailure(call: Call<ProductsResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }




}