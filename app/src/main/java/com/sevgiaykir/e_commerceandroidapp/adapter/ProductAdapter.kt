package com.sevgiaykir.e_commerceandroidapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sevgiaykir.e_commerceandroidapp.databinding.ProductCardDesignBinding
import com.sevgiaykir.e_commerceandroidapp.entity.Products
import com.sevgiaykir.e_commerceandroidapp.fragment.HomePageFragmentDirections
import com.sevgiaykir.e_commerceandroidapp.viewmodel.HomePageViewModel
import com.sevgiaykir.e_commerceandroidapp.viewmodel.ProductDetailsPageViewModel
import com.squareup.picasso.Picasso

class ProductAdapter(var mContext:Context, var productList:List<Products>, var viewModel:HomePageViewModel):RecyclerView.Adapter<ProductAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(productCardDesignBinding: ProductCardDesignBinding):RecyclerView.ViewHolder(productCardDesignBinding.root){
        var design: ProductCardDesignBinding

        init{
            this.design=productCardDesignBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater=LayoutInflater.from(mContext)
        val design=ProductCardDesignBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val product=productList.get(position)
        holder.design.productObject=product

        //picasso
        Picasso.get().load(product.urun_gorsel_url).into(holder.design.imageViewProduct)

        holder.design.prodCardview.setOnClickListener {
            val pass=HomePageFragmentDirections.transitionHomePageToProductDetails(product)
            Navigation.findNavController(it).navigate(pass)
        }

        holder.design.buttonGoDetail.setOnClickListener {
            val pass=HomePageFragmentDirections.transitionHomePageToProductDetails(product)
            Navigation.findNavController(it).navigate(pass)
        }

        holder.design.buttonGoCart.setOnClickListener {
            viewModel.updateCart(product.id,1)
            Toast.makeText(mContext, "Sepete eklendi!", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return productList.size
    }
}