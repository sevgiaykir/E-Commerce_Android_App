package com.sevgiaykir.e_commerceandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.sevgiaykir.e_commerceandroidapp.entity.ProductsResponse
import com.sevgiaykir.e_commerceandroidapp.retrofit.ApiUtils
import com.sevgiaykir.e_commerceandroidapp.retrofit.ProductsDAOInterface
import com.sevgiaykir.e_commerceandroidapp.retrofit.UsersDAOInterface
import com.sevgiaykir.e_commerceandroidapp.databinding.ActivityLoginRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRegisterActivity : AppCompatActivity() {

    private lateinit var design:ActivityLoginRegisterBinding

    private lateinit var pdaoi:ProductsDAOInterface
    private lateinit var udaoi:UsersDAOInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design= DataBindingUtil.setContentView(this,R.layout.activity_login_register)


        val loginNavHostFragment=supportFragmentManager.findFragmentById(R.id.login_nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(design.loginTopNav,loginNavHostFragment.navController)

        pdaoi=ApiUtils.getProductsDaoInterface()
        udaoi=ApiUtils.getUsersDaoInterface()

        //searchProd()
        //insertUser()
        //searchUser()
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
}

