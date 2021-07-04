package com.sevgiaykir.e_commerceandroidapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.sevgiaykir.e_commerceandroidapp.databinding.CartCardDesignBinding
import com.sevgiaykir.e_commerceandroidapp.databinding.ProductCardDesignBinding
import com.sevgiaykir.e_commerceandroidapp.entity.Products
import com.sevgiaykir.e_commerceandroidapp.fragment.CartPageFragment
import com.sevgiaykir.e_commerceandroidapp.viewmodel.CartPageViewModel
import com.squareup.picasso.Picasso

class CartAdapter(var mContext: Context, var cartProductList:List<Products>,var viewModel:CartPageViewModel,var fragment: CartPageFragment)
    :RecyclerView.Adapter<CartAdapter.CardDesignHolder>()  {

    inner class CardDesignHolder(cartCardDesignBinding: CartCardDesignBinding): RecyclerView.ViewHolder(cartCardDesignBinding.root){
        var design: CartCardDesignBinding

        init{
            this.design=cartCardDesignBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater= LayoutInflater.from(mContext)
        val design= CartCardDesignBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val cartProduct=cartProductList.get(position)
        holder.design.cartProductObject=cartProduct

        //picasso
        Picasso.get().load(cartProduct.urun_gorsel_url).into(holder.design.imageViewCartProduct)

        holder.design.buttonRemoveCart.setOnClickListener {
            viewModel.removeCartProduct(cartProduct.id,0)
            Toast.makeText(mContext, "Sepetten çıkarıldı!", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return cartProductList.size
    }
}