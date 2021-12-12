package com.dawaai.myecommerceapp.fragment

import com.dawaai.myecommerceapp.databinding.FragmentAllItemBinding
import com.dawaai.myecommerceapp.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllItemFragment  : BaseFragment<FragmentAllItemBinding>() {
    override fun getViewBinding()= FragmentAllItemBinding.inflate(layoutInflater)



}