package com.sevgiaykir.e_commerceandroidapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.sevgiaykir.e_commerceandroidapp.R
import com.sevgiaykir.e_commerceandroidapp.viewmodel.RegisterPageViewModel
import com.sevgiaykir.e_commerceandroidapp.databinding.FragmentRegisterPageBinding

class RegisterPageFragment : Fragment() {

    private lateinit var design: FragmentRegisterPageBinding
    private lateinit var viewModel: RegisterPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater, R.layout.fragment_register_page, container, false)
        design.registerPageFragment=this

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp:RegisterPageViewModel by viewModels()
        viewModel=temp
    }

    fun buttonRegister(name_surname:String, email:String, phoneNo:String, password:String){
        viewModel.register(name_surname,email,phoneNo,password)
    }
}