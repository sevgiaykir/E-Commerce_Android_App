package com.sevgiaykir.e_commerceandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sevgiaykir.e_commerceandroidapp.Entity.CRUDResponse
import com.sevgiaykir.e_commerceandroidapp.Entity.ProductsResponse
import com.sevgiaykir.e_commerceandroidapp.Entity.UsersResponse
import com.sevgiaykir.e_commerceandroidapp.Retrofit.ApiUtils
import com.sevgiaykir.e_commerceandroidapp.Retrofit.ProductsDAOInterface
import com.sevgiaykir.e_commerceandroidapp.Retrofit.UsersDAOInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var pdaoi:ProductsDAOInterface
    private lateinit var udaoi:UsersDAOInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pdaoi=ApiUtils.getProductsDaoInterface()
        udaoi=ApiUtils.getUsersDaoInterface()

        //searchProd()
        //insertUser()
        searchUser()
    }

    fun searchProd(){
        pdaoi.searchProduct("canerture").enqueue(object :Callback<ProductsResponse>{
            override fun onResponse(
                call: Call<ProductsResponse>?,
                response: Response<ProductsResponse>
            ) {
                val productsList=response.body().urunler

                for(p in productsList){
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
    /*
    fun insertProd(){
        pdaoi.insertProduct("sevgiaykir","",1.0,"","").enqueue(object:Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>) {
                Log.e("Başarı",response.body().success.toString())
                Log.e("Mesaj",response.body().message)
            }

            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }  */

    fun insertUser(){
        udaoi.signUp("sevgiaykir@gmail.com","sevgi999","Sevgi Aykır","5077777777").enqueue(object:Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>) {
                Log.e("Başarı",response.body().success.toString())
                Log.e("Mesaj",response.body().message)
            }

            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }

    fun searchUser(){
        udaoi.login("sevgiaykir@gmail.com","sevgi999").enqueue(object :Callback<UsersResponse> {
            override fun onResponse(
                call: Call<UsersResponse>?,
                response: Response<UsersResponse>
            ) {
                val usersList = response.body().kullanicilar

                for (p in usersList) {
                    if (p.deger == 1) {
                        Log.e("*****", "******")
                        Log.e("1", p.ad_soyad)
                        Log.e("2", p.mail_adres)
                        Log.e("3", p.sifre)
                        Log.e("4", p.telefon)
                        Log.e("5", p.deger.toString())
                    } else if (p.deger == 0) {
                        Log.e("giriş", "yapılamadı")
                    }
                }
            }

            override fun onFailure(call: Call<UsersResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }
}

