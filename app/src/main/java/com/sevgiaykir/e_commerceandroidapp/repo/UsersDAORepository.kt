package com.sevgiaykir.e_commerceandroidapp.repo

import androidx.lifecycle.MutableLiveData
import com.sevgiaykir.e_commerceandroidapp.entity.CRUDResponse
import com.sevgiaykir.e_commerceandroidapp.entity.Users
import com.sevgiaykir.e_commerceandroidapp.entity.UsersResponse
import com.sevgiaykir.e_commerceandroidapp.retrofit.ApiUtils
import com.sevgiaykir.e_commerceandroidapp.retrofit.UsersDAOInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersDAORepository {
    private val usersList:MutableLiveData<List<Users>>
    private val udaoi:UsersDAOInterface

    private var comingValue=MutableLiveData<Int>()

    init{
        udaoi=ApiUtils.getUsersDaoInterface()
        usersList= MutableLiveData()
        comingValue=MutableLiveData()
    }

    fun bringUsers():MutableLiveData<List<Users>> {
        return usersList
    }

    fun bringValue():MutableLiveData<Int> {
        return comingValue
    }

    fun insertUser(name_surname:String, email:String, phoneNo:String, password:String){
        udaoi.signUp(name_surname,email,phoneNo,password).enqueue(object: Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>) {
            }

            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }

    fun searchUser(email:String, password:String){
        udaoi.login(email,password).enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>?, response: Response<UsersResponse>) {
                val list = response.body().kullanicilar
                usersList.value=list


                for (p in list) {
                    comingValue.value=p.deger
                    //println(p.deger)
                    /*
                    if (p.deger == 1) {

                        Log.e("*****", "******")
                        Log.e("1", p.ad_soyad)
                        Log.e("2", p.mail_adres)
                        Log.e("3", p.sifre)
                        Log.e("4", p.telefon)
                        Log.e("5", p.deger.toString())
                    } else if (p.deger == 0) {
                        Log.e("giriş", "yapılamadı")
                    }  */
                }
            }
            //sevgiaykir@gmail.com
            //sevgi999

            override fun onFailure(call: Call<UsersResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }

}