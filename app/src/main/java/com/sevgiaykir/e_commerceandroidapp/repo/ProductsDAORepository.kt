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

    init{
        pdaoi=ApiUtils.getProductsDaoInterface()
        productList= MutableLiveData()
    }

    fun bringProducts():MutableLiveData<List<Products>> {
        return productList
    }

    fun searchProd(satici_adi:String){
        pdaoi.searchProduct(satici_adi).enqueue(object : Callback<ProductsResponse> {
            override fun onResponse(
                call: Call<ProductsResponse>?,
                response: Response<ProductsResponse>
            ) {
                val list=response.body().urunler
                productList.value=list

                for(p in list){
                    Log.e("*****","******")
                    Log.e("info", p.id.toString())
                    //Log.e("info1", p.satici_adi)
                    Log.e("info2", p.urun_adi)
                    Log.e("info3", p.urun_fiyat.toString())
                    Log.e("info4", p.urun_aciklama)
                    Log.e("info5", p.urun_gorsel_url)
                    Log.e("info6", p.sepet_durum.toString())
                    Log.e("info7", p.urun_indirimli_mi.toString())

                }
            }

            override fun onFailure(call: Call<ProductsResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }

    //ürün eklemek için

    fun insertProd(satici_adi:String,urun_adi:String,urun_fiyat:String,urun_aciklama:String,urun_gorsel_url:String){
        pdaoi.insertProduct(satici_adi,urun_adi,urun_fiyat,urun_aciklama,urun_gorsel_url).enqueue(object:
            Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>) {
            }

            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }
    fun updateCartSituation(id:Int,sepet_durum:Int) {
        pdaoi.updateCart(id,sepet_durum).enqueue(object: Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>) {
                Log.e("Güncelleme Başarılı", response.body().success.toString())
                Log.e("Güncelleme Başarısız", response.body().message)
            }

            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {}
        })
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


}