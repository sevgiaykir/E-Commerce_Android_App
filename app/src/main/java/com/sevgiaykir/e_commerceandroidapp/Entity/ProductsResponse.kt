package com.sevgiaykir.e_commerceandroidapp.Entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductsResponse(@SerializedName("urunler")
                           @Expose
                           var urunler:List<Products>,
                            @SerializedName("success")
                           @Expose
                           var success:Int) {
}