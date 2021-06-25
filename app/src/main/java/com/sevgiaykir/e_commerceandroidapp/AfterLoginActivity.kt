package com.sevgiaykir.e_commerceandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.sevgiaykir.e_commerceandroidapp.databinding.ActivityAfterLoginBinding
import com.sevgiaykir.e_commerceandroidapp.databinding.ActivityLoginRegisterBinding
import kotlinx.android.synthetic.main.activity_after_login.*

class AfterLoginActivity : AppCompatActivity() {

    private lateinit var design: ActivityAfterLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design= DataBindingUtil.setContentView(this,R.layout.activity_after_login)

        val afterLoginNavHostFragment=supportFragmentManager.findFragmentById(R.id.after_login_nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(design.bottomNav,afterLoginNavHostFragment.navController)
   }
}