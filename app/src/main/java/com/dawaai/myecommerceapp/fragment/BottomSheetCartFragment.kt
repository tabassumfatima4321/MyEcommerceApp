package com.dawaai.myecommerceapp.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.dawaai.myecommerceapp.databinding.FragmentBottomSheetCartBinding
import com.dawaai.myecommerceapp.helper.loadImage
import com.dawaai.myecommerceapp.model.Product

class BottomSheetCartFragment : BaseBottomSheetFragment<FragmentBottomSheetCartBinding>()  {
    private val args : BottomSheetCartFragmentArgs by navArgs()
     var product: Product? = null

    override fun getViewBinding() = FragmentBottomSheetCartBinding.inflate(layoutInflater)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        product=args.product
        initViews()
    }
    fun initViews()
    {
        product?.let {
            binding.tvTitle.text=it.title
            binding.tvDesc.text=it.description
            binding.tvPrice.text=it.price.toString()
            it.image?.let { img -> binding.ivSKU.loadImage(img,requireContext()) }
        }
    }
}