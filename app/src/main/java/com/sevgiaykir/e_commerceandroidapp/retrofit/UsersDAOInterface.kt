package com.sevgiaykir.e_commerceandroidapp.retrofit

import com.sevgiaykir.e_commerceandroidapp.entity.CRUDResponse
import com.sevgiaykir.e_commerceandroidapp.entity.UsersResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UsersDAOInterface {
    @POST("giris_yap.php")
    @FormUrlEncoded
    fun login(@Field("mail_adres")mail_adres:String,
              @Field("sifre")sifre:String): Call<UsersResponse>

    @POST("uye_ol.php")
    @FormUrlEncoded
    fun signUp(@Field("ad_soyad")ad_soyad:String,
               @Field("mail_adres")mail_adres:String,
               @Field("telefon")telefon:String,
               @Field("sifre")sifre:String):Call<CRUDResponse>
}