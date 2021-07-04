package com.sevgiaykir.e_commerceandroidapp.repo

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.sevgiaykir.e_commerceandroidapp.LoginRegisterActivity
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

    private val activity: LoginRegisterActivity? = null
    private var comingUser:MutableLiveData<List<Users>>

    init{
        udaoi=ApiUtils.getUsersDaoInterface()
        usersList= MutableLiveData()
        comingUser= MutableLiveData()
        comingValue=MutableLiveData()

    }

    fun bringUsers():MutableLiveData<List<Users>> {
        return usersList
    }

    fun bringValue():MutableLiveData<Int> {
        return comingValue
    }
    fun bringUserInfo():MutableLiveData<List<Users>> {
        return comingUser
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
                usersList.value = list
                var arrayListUserInfos = arrayListOf<Users>()

                for (u in list) {
                    comingValue.value = u.deger
                    //println(p.deger)
                    if (u.deger == 1) {
                        arrayListUserInfos.add(u)
                    }
                }
                comingUser.value=arrayListUserInfos
            }
            //sevgiaykir@gmail.com
            //sevgi999

            override fun onFailure(call: Call<UsersResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }

    fun saveData() {
        val sharedPref : SharedPreferences?= activity?.getPreferences(Context.MODE_PRIVATE);
        //val editor=sharedPref.edit()
    }



}