package com.sevgiaykir.e_commerceandroidapp.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UsersResponse (@SerializedName("kullanicilar")
                         @Expose
                         var kullanicilar:List<Users>,
                          @SerializedName("success")
                         @Expose
                         var success:Int) {
}