package com.sevgiaykir.e_commerceandroidapp.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.sevgiaykir.e_commerceandroidapp.AfterLoginActivity
import com.sevgiaykir.e_commerceandroidapp.LoginRegisterActivity
import com.sevgiaykir.e_commerceandroidapp.R
import com.sevgiaykir.e_commerceandroidapp.databinding.FragmentLoginPageBinding
import com.sevgiaykir.e_commerceandroidapp.viewmodel.LoginPageViewModel
import com.sevgiaykir.e_commerceandroidapp.viewmodel.RegisterPageViewModel

class LoginPageFragment : Fragment() {

    private lateinit var design:FragmentLoginPageBinding
    private lateinit var viewModel: LoginPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater, R.layout.fragment_login_page, container, false)
        design.loginPageFragment=this

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: LoginPageViewModel by viewModels()
        viewModel=temp
    }

    fun buttonLogin(email:String, password:String) {
        viewModel.login(email, password)
        viewModel.deger.observe(viewLifecycleOwner,{
            println(it)
            if(it==1){
                val intent= Intent(getActivity(),AfterLoginActivity::class.java)
                getActivity()?.startActivity(intent)
            }
            else if(it==0){
                Toast.makeText(requireContext(),"Giriş Yapılamadı!", Toast.LENGTH_SHORT).show()
            }
        })
        //sayfa geçişi


        //Navigation.findNavController(view).navigate(R.id.transitionHomePageFragment)
    }

    fun buttonGoToRegisterPage(view:View) {
        Log.e("deneme","dsfs")
    }

}