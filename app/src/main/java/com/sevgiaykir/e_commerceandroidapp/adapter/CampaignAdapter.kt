package com.sevgiaykir.e_commerceandroidapp.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.sevgiaykir.e_commerceandroidapp.databinding.CampaignCartDesignBinding
import com.sevgiaykir.e_commerceandroidapp.databinding.CartCardDesignBinding
import com.sevgiaykir.e_commerceandroidapp.entity.Products
import com.sevgiaykir.e_commerceandroidapp.fragment.CampaignPageFragmentDirections
import com.sevgiaykir.e_commerceandroidapp.fragment.HomePageFragmentDirections
import com.sevgiaykir.e_commerceandroidapp.viewmodel.CartPageViewModel
import com.squareup.picasso.Picasso

class CampaignAdapter(var mContext: Context, var campaignProductList:List<Products>)
: RecyclerView.Adapter<CampaignAdapter.CardDesignHolder>() {


    inner class CardDesignHolder(campaignCartDesignBinding: CampaignCartDesignBinding) :
        RecyclerView.ViewHolder(campaignCartDesignBinding.root) {
        var design: CampaignCartDesignBinding

        init {
            this.design = campaignCartDesignBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater= LayoutInflater.from(mContext)
        val design= CampaignCartDesignBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val campaignProduct=campaignProductList.get(position)
        holder.design.campaignProductObject=campaignProduct

        //picasso
        Picasso.get().load(campaignProduct.urun_gorsel_url).into(holder.design.imageViewCampProd)

        holder.design.campProdCartview.setOnClickListener {
            val pass= CampaignPageFragmentDirections.transitionCampaignPageToProductDetails(campaignProduct)
            Navigation.findNavController(it).navigate(pass)
        }

        holder.design.buttonCampGoDetail.setOnClickListener {
            val pass= CampaignPageFragmentDirections.transitionCampaignPageToProductDetails(campaignProduct)
            Navigation.findNavController(it).navigate(pass)
        }

        holder.design.textViewCampProdPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        //   android:text="@{campaignProductObject.urun_fiyat} + ' ' +'\u20BA'}"
        //println(campaignProduct.urun_fiyat.toInt())
        //holder.design.textViewCampProdPrice2.text=(campaignProduct.urun_fiyat.toInt()-campaignProduct.urun_fiyat.toInt()/10).toString()
    }

    override fun getItemCount(): Int {
        return campaignProductList.size
    }
}