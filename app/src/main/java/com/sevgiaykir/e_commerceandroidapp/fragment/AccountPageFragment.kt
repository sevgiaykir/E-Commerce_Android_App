package com.sevgiaykir.e_commerceandroidapp.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sevgiaykir.e_commerceandroidapp.R
import com.sevgiaykir.e_commerceandroidapp.databinding.FragmentAccountPageBinding
import com.sevgiaykir.e_commerceandroidapp.viewmodel.AccountPageViewModel

class AccountPageFragment : Fragment() {

    private lateinit var design: FragmentAccountPageBinding
    private lateinit var viewModel: AccountPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design= DataBindingUtil.inflate(inflater, R.layout.fragment_account_page, container, false)
        design.accountPageFragment=this

        loadData()

        return design.root
    }

    fun loadData(){
        val sharedPreferences= context?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedName= sharedPreferences?.getString("STRING_NAME",null)
        val savedMail= sharedPreferences?.getString("STRING_MAIL",null)
        val savedPhone= sharedPreferences?.getString("STRING_PHONE",null)

        design.textViewNameSurname.text=savedName
        design.textViewEmail.text=savedMail
        design.textViewPhone.text=savedPhone

    }

}