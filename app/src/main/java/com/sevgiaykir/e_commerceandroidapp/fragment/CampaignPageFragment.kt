package com.sevgiaykir.e_commerceandroidapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.sevgiaykir.e_commerceandroidapp.R
import com.sevgiaykir.e_commerceandroidapp.adapter.CampaignAdapter
import com.sevgiaykir.e_commerceandroidapp.databinding.FragmentCampaignPageBinding
import com.sevgiaykir.e_commerceandroidapp.viewmodel.CampaignPageViewModel

class CampaignPageFragment : Fragment() {

    private lateinit var design:FragmentCampaignPageBinding
    private lateinit var viewModel: CampaignPageViewModel
    private lateinit var adapter: CampaignAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater, R.layout.fragment_campaign_page, container, false)
        design.campaignPageFragment=this

        viewModel.campProdList.observe(viewLifecycleOwner,{ campProductList ->
            adapter= CampaignAdapter(requireContext(),campProductList)
            design.adapter=adapter
        })

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: CampaignPageViewModel by viewModels()
        viewModel=temp
    }
}