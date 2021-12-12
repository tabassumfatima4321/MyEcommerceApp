package com.dawaai.myecommerceapp.fragment

import com.dawaai.myecommerceapp.databinding.FragmentFavoriteItemBinding
import com.dawaai.myecommerceapp.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteItemFragment : BaseFragment<FragmentFavoriteItemBinding>() {
    override fun getViewBinding()= FragmentFavoriteItemBinding.inflate(layoutInflater)



}