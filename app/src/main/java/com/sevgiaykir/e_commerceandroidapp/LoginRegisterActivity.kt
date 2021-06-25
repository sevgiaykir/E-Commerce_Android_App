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
import com.sevgiaykir.e_commerceandroidapp.entity.CRUDResponse
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

        //updateCartSituation()
        //updateDiscountSituation()
        //insertProd()
        //searchProd()


    }

}

