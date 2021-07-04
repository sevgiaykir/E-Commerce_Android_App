package com.sevgiaykir.e_commerceandroidapp.fragment

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.sevgiaykir.e_commerceandroidapp.AfterLoginActivity
import com.sevgiaykir.e_commerceandroidapp.R
import com.sevgiaykir.e_commerceandroidapp.viewmodel.RegisterPageViewModel
import com.sevgiaykir.e_commerceandroidapp.databinding.FragmentRegisterPageBinding
import kotlinx.android.synthetic.main.fragment_login_page.*
import kotlinx.android.synthetic.main.fragment_login_page.emailTextInputLayout
import kotlinx.android.synthetic.main.fragment_login_page.passwordTextInputLayout
import kotlinx.android.synthetic.main.fragment_register_page.*

class RegisterPageFragment : Fragment() {

    private lateinit var design: FragmentRegisterPageBinding
    private lateinit var viewModel: RegisterPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater, R.layout.fragment_register_page, container, false)
        design.registerPageFragment=this

        val emailInput=design.emailEditText
        val passwordInput=design.passwordEditText
        val nameSurnameInput=design.namesurnameEditText
        val phoneInput=design.phoneEditText

        //name-surname validation
        nameSurnameInput.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                namesurnameTextInputLayout.setError(validateNameSurname(nameSurnameInput.text.toString()))
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        //e-mail validation
        emailInput.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                emailTextInputLayout.setError(validateEmailAddress(emailInput.text.toString()))
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        //phone no validation
        phoneInput.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                phoneTextInputLayout.setError(validatePhone(emailInput.text.toString()))
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        //password validation
        passwordInput.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                passwordTextInputLayout.setError(validatePassword(passwordInput.text.toString()))
            }

            override fun afterTextChanged(s: Editable?) {}
        })


        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp:RegisterPageViewModel by viewModels()
        viewModel=temp
    }

    fun buttonRegister(name_surname:String, email:String, phoneNo:String, password:String){
        namesurnameTextInputLayout.setError(validateNameSurname(email))
        emailTextInputLayout.setError(validateEmailAddress(email))
        phoneTextInputLayout.setError(validatePhone(password))
        passwordTextInputLayout.setError(validatePassword(password))
        viewModel.register(name_surname,email,phoneNo,password)
        //val intent = Intent(getActivity(), AfterLoginActivity::class.java)
        //getActivity()?.startActivity(intent)
        Toast.makeText(requireContext(),"Kayıt Olundu, bilgilerinizle hesabınıza giriş yapabilirsiniz!", Toast.LENGTH_SHORT).show()
    }

    fun validateNameSurname(nameSurnameInput: String):String? {
        if (nameSurnameInput.isEmpty() || nameSurnameInput.isBlank() || nameSurnameInput.length==0) {
            return "Ad-Soyad alanı boş bırakılamaz."
        }
        else if (!nameSurnameInput.contains(" ")) {
            return "Geçersiz ad-soyad formatı!"
        }
        else{
            return null
        }
        return null
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

    fun validatePhone(phoneInput: String):String? {
        if (phoneInput.isEmpty() || phoneInput.isBlank() || phoneInput.length==0) {
            return "Cep telefonu alanı boş bırakılamaz."
        }
        else if (!Patterns.PHONE.matcher(phoneInput).matches()) {
            return "Geçersiz telefon numarası formatı!"
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
}