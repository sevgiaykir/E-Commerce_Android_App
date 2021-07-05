package com.sevgiaykir.e_commerceandroidapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.sevgiaykir.e_commerceandroidapp.AfterLoginActivity
import com.sevgiaykir.e_commerceandroidapp.R
import com.sevgiaykir.e_commerceandroidapp.adapter.CartAdapter
import com.sevgiaykir.e_commerceandroidapp.adapter.ProductAdapter
import com.sevgiaykir.e_commerceandroidapp.databinding.FragmentCartPageBinding
import com.sevgiaykir.e_commerceandroidapp.retrofit.ApiUtils
import com.sevgiaykir.e_commerceandroidapp.retrofit.ProductsDAOInterface
import com.sevgiaykir.e_commerceandroidapp.viewmodel.CartPageViewModel

class CartPageFragment : Fragment() {

    private lateinit var design:FragmentCartPageBinding
    private lateinit var viewModel: CartPageViewModel
    private lateinit var pdaoi: ProductsDAOInterface
    private lateinit var adapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater, R.layout.fragment_cart_page, container, false)
        pdaoi=ApiUtils.getProductsDaoInterface()
        design.cartPageFragment=this

        viewModel.cartProdList.observe(viewLifecycleOwner, { cartProductList ->
            adapter=CartAdapter(requireContext(), cartProductList, viewModel, CartPageFragment())
            design.adapter=adapter
        })

        design.toolbarCartPage.setNavigationOnClickListener {
            val myIntent = Intent(activity, AfterLoginActivity::class.java)
            startActivity(myIntent)
        }
        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp:CartPageViewModel by viewModels()
        viewModel=temp
    }

    fun refresh() {
        super.onResume()
        viewModel.loadCartProduct()
    }
}