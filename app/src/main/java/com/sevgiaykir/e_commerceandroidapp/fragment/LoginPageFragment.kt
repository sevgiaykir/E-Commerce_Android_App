package com.sevgiaykir.e_commerceandroidapp.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.sevgiaykir.e_commerceandroidapp.AfterLoginActivity
import com.sevgiaykir.e_commerceandroidapp.R
import com.sevgiaykir.e_commerceandroidapp.databinding.FragmentLoginPageBinding
import com.sevgiaykir.e_commerceandroidapp.viewmodel.LoginPageViewModel
import kotlinx.android.synthetic.main.fragment_login_page.*


class LoginPageFragment : Fragment() {

    private lateinit var design:FragmentLoginPageBinding
    private lateinit var viewModel: LoginPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_login_page, container, false)
        design.loginPageFragment = this

        val emailInput=design.emailEditText
        val passwordInput=design.passwordEditText

        //e-mail validation
        emailInput.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                emailTextInputLayout.setError(validateEmailAddress(emailInput.text.toString()))
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        //password validation
        passwordInput.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                passwordTextInputLayout.setError(validatePassword(passwordInput.text.toString()))
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        return design.root
    }



    fun validateEmailAddress(emailInput: String):String? {
        if (emailInput.isEmpty() || emailInput.isBlank() || emailInput.length==0) {
            return "E-mail alanı boş bırakılamaz."
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            return "Geçersiz e-mail formatı!"
        }
        else{
            return null
        }
        return null
    }

    fun validatePassword(passwordInput: String):String? {
        if (passwordInput.isEmpty() || passwordInput.isBlank() || passwordInput.length==0) {
            return "Şifre alanı boş bırakılamaz."
        }
        else if (passwordInput.length<6) {
            return "Şifre en az 6 karakter içermeli!"
        }
        else{
            return null
        }
        return null
    }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val temp: LoginPageViewModel by viewModels()
            viewModel = temp
        }

        fun buttonLogin(email: String, password: String) {
            emailTextInputLayout.setError(validateEmailAddress(email))
            passwordTextInputLayout.setError(validatePassword(password))
            viewModel.login(email, password)
            viewModel.deger.observe(viewLifecycleOwner, {
                println(it)
                if (it == 1) {
                    val intent = Intent(getActivity(), AfterLoginActivity::class.java)
                    getActivity()?.startActivity(intent)
                    viewModel.user.observe(viewLifecycleOwner, { userInfo ->
                        val sharedPreferences= context?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
                        val editor= sharedPreferences?.edit()
                        editor?.apply{
                            for (i in userInfo){
                                putString("STRING_NAME",i.ad_soyad)
                                putString("STRING_MAIL",i.mail_adres)
                                putString("STRING_PHONE",i.telefon)
                            }
                        }?.apply()
                        //Toast.makeText(requireContext(),"data saved",Toast.LENGTH_SHORT).show()

                    })
                } else if (it == 0) {
                    //Snackbar.make(requireActivity().findViewById(android.R.id.content), "Mail adresiniz veya şifreniz hatalı!", Snackbar.LENGTH_LONG).show()
                    Toast.makeText(requireContext(), "Mail adresiniz veya şifreniz hatalı!", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
