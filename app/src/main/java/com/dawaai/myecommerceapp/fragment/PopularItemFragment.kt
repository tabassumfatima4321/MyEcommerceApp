package com.dawaai.myecommerceapp.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dawaai.myecommerceapp.adapter.ProductAdapter
import com.dawaai.myecommerceapp.viewmodel.ProductViewModel
import com.dawaai.myecommerceapp.databinding.FragmentPopularItemBinding
import com.dawaai.myecommerceapp.model.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularItemFragment  : BaseFragment<FragmentPopularItemBinding>() {
    private val viewModel by viewModels<ProductViewModel>()
    override fun getViewBinding()= FragmentPopularItemBinding.inflate(layoutInflater)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       setObserver()
    }
    private fun setObserver()
    {
        viewModel.getProducts()
        binding.progressbar.visibility=View.VISIBLE
        viewModel.data.observe(requireActivity(), {

                initRecylerView(it.body())
            binding.progressbar.visibility=View.GONE


        })
    }
    fun initRecylerView(products: List<Product>?)
    {
        products?.let {
            val adapter= ProductAdapter(requireContext(),it,::onClickProduct)
            binding.rvProducts.also {
                it.layoutManager= LinearLayoutManager(requireContext())
                it.adapter=adapter
            }
        }

    }
    fun onClickProduct(item:Product)
    {
        findNavController().navigate(ProductsFragmentDirections.actionProductsFragment2ToBottomSheetCartFragment(item))
    }
}