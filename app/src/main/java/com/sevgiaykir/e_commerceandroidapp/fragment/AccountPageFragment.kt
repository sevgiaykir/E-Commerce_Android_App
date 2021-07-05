package com.sevgiaykir.e_commerceandroidapp.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sevgiaykir.e_commerceandroidapp.AfterLoginActivity
import com.sevgiaykir.e_commerceandroidapp.LoginRegisterActivity
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

        (activity as AppCompatActivity).setSupportActionBar(design.toolbarAccountPage)
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowTitleEnabled(false)

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_exit -> {
                val intent = Intent(getActivity(), LoginRegisterActivity::class.java)
                getActivity()?.startActivity(intent)
                Toast.makeText(requireContext(), "Çıkış yapıldı.", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
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