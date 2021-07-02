package com.sevgiaykir.e_commerceandroidapp.retrofit

import com.sevgiaykir.e_commerceandroidapp.entity.CRUDResponse
import com.sevgiaykir.e_commerceandroidapp.entity.ProductsResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ProductsDAOInterface {
    @POST("urunler.php")
    @FormUrlEncoded
    fun searchProduct(@Field("satici_adi")satici_adi:String):Call<ProductsResponse>

    @POST("urun_ekle.php")
    @FormUrlEncoded
    fun insertProduct(@Field("id") id: Int,
                      @Field("satici_adi") satici_adi:String,
                      @Field("urun_adi") urun_adi:String,
                      @Field("urun_fiyat") urun_fiyat: String,
                      @Field("urun_aciklama") urun_aciklama:String,
                      @Field("urun_gorsel_url") urun_gorsel_url:String,
                      @Field("urun_indirimli_mi") urun_indirimli_mi: Int,
                      @Field("sepet_durum") sepet_durum:Int):Call<CRUDResponse>

    @POST("indirimli_urun_durum_degistir.php")
    @FormUrlEncoded
    fun updateDiscount(@Field("id")id:Int,
                       @Field("urun_indirimli_mi")urun_indirimli_mi:Int):Call<CRUDResponse>

    @POST("sepet_durum_degistir.php")
    @FormUrlEncoded
    fun updateCart(@Field("id")id:Int,
                   @Field("sepet_durum")sepet_durum:Int):Call<CRUDResponse>
}