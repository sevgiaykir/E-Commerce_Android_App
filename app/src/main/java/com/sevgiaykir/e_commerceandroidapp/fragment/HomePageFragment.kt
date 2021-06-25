package com.sevgiaykir.e_commerceandroidapp.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sevgiaykir.e_commerceandroidapp.R
import com.sevgiaykir.e_commerceandroidapp.adapter.ProductAdapter
import com.sevgiaykir.e_commerceandroidapp.databinding.FragmentHomePageBinding
import com.sevgiaykir.e_commerceandroidapp.viewmodel.HomePageViewModel

class HomePageFragment : Fragment() {

    private lateinit var design:FragmentHomePageBinding
    private lateinit var viewModel: HomePageViewModel
    private lateinit var adapter:ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false)
        design.homePageFragment=this

        (activity as AppCompatActivity).setSupportActionBar(design.toolbarHomePage)
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowTitleEnabled(false)

        design.toolbarHomePage.setOnMenuItemClickListener{
            menuItem ->
            when (menuItem.itemId) {
                R.id.action_go_cart -> {
                    Toast.makeText(requireContext(),"Basıldı!", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        viewModel.prodList.observe(viewLifecycleOwner,{ productList ->
            adapter= ProductAdapter(requireContext(),productList)
            design.adapter=adapter
        })
        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val temp: HomePageViewModel by viewModels()
        viewModel=temp
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_cart_icon,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    //sayfaya her geri dönüldüğünde yenilenmesi için
/*
    override fun onResume() {
        super.onResume()
        viewModel.loadProduct()
    } */
}