package com.dawaai.myecommerceapp.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dawaai.myecommerceapp.R
import com.dawaai.myecommerceapp.databinding.FragmentAllItemBinding
import com.dawaai.myecommerceapp.databinding.FragmentFavoriteItemBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllItemFragment  : BaseFragment<FragmentAllItemBinding>() {
    override fun getViewBinding()= FragmentAllItemBinding.inflate(layoutInflater)



}