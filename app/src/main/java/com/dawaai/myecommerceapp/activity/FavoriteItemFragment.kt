package com.dawaai.myecommerceapp.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dawaai.myecommerceapp.R
import com.dawaai.myecommerceapp.databinding.FragmentFavoriteItemBinding
import com.dawaai.myecommerceapp.databinding.FragmentProductsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteItemFragment : BaseFragment<FragmentFavoriteItemBinding>() {
    override fun getViewBinding()= FragmentFavoriteItemBinding.inflate(layoutInflater)



}