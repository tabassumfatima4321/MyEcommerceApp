package com.dawaai.myecommerceapp.activity

import android.os.Bundle
import android.view.View
import com.dawaai.myecommerceapp.databinding.FragmentProductsBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductsBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewPager()

    }

    override fun getViewBinding()= FragmentProductsBinding.inflate(layoutInflater)
    private fun setUpViewPager()
    {
        activity?.let {
            val fragmentList = arrayListOf(
                PopularItemFragment(),
                FavoriteItemFragment(),
                AllItemFragment()
            )
           val adapter = ViewPagerAdapter(
                fragmentList,
                requireActivity().supportFragmentManager,
                lifecycle
            )

            binding.viewpager.adapter = adapter
            TabLayoutMediator(
                binding.tabLayout, binding.viewpager
            ) { tab,
                position ->
                tab.text = when (position) {
                    0 -> "Popular"
                    1 -> "Favorites"
                    2 -> "All Items"
                    else -> ""
                }
            }.attach()

        }


    }

}