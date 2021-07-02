package com.sevgiaykir.e_commerceandroidapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.sevgiaykir.e_commerceandroidapp.AfterLoginActivity
import com.sevgiaykir.e_commerceandroidapp.R
import com.sevgiaykir.e_commerceandroidapp.databinding.FragmentProductDetailsPageBinding
import com.sevgiaykir.e_commerceandroidapp.viewmodel.LoginPageViewModel
import com.sevgiaykir.e_commerceandroidapp.viewmodel.ProductDetailsPageViewModel
import com.squareup.picasso.Picasso

class ProductDetailsPageFragment : Fragment() {

    private lateinit var design:FragmentProductDetailsPageBinding
    private lateinit var viewModel: ProductDetailsPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater, R.layout.fragment_product_details_page, container, false)
        design.detailPageFragment=this

        design.toolbarProductDetailsPage.setNavigationOnClickListener {
            val myIntent = Intent(activity, AfterLoginActivity::class.java)
            startActivity(myIntent)
        }

        val bundle:ProductDetailsPageFragmentArgs by navArgs()
        val transmittedObj=bundle.prodObject


        //picasso
        Picasso.get().load(transmittedObj.urun_gorsel_url).into(design.imageViewProdDetail)

        design.productObject=transmittedObj

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: ProductDetailsPageViewModel by viewModels()
        viewModel=temp
    }

    fun buttonUpdateCart(id:Int, sepet_durum:Int) {
        viewModel.updateCart(id,sepet_durum)
        Toast.makeText(requireContext(), "Ürün sepete eklendi.", Toast.LENGTH_SHORT).show()
        /*
        viewModel.success.observe(viewLifecycleOwner, {
            if(it==1) {
                Toast.makeText(requireContext(), "Ürün sepete eklendi.", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(), "Bir Hata Oluştu.", Toast.LENGTH_SHORT).show()
            }
        }) */
    }

}