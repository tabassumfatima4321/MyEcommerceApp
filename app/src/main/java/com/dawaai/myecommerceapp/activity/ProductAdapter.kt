package com.dawaai.myecommerceapp.activity

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dawaai.myecommerceapp.databinding.RowProductBinding
import com.dawaai.myecommerceapp.helper.loadImage
import com.dawaai.myecommerceapp.model.Product

class ProductAdapter (private val context: Context,
                      private val products:List<Product>
                      ,private  val itemClickListener: (item:Product) -> Unit):
    RecyclerView.Adapter<ProductAdapter.ItemViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductAdapter.ItemViewHolder {
        val  binding = RowProductBinding.inflate(LayoutInflater.from(context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ItemViewHolder, position: Int) {
        holder.bindItems(products[position])
    }

    override fun getItemCount()=products.size
    inner class ItemViewHolder(val binding: RowProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItems(product:Product)
        {
            binding.title.text=product.title
            product.image?.let { binding.ivProduct.loadImage(it,context) }
            binding.cardViewOuter.setOnClickListener {
                product?.let { it1 -> itemClickListener(it1) }
            }

        }
    }

}