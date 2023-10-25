package com.ruhlanusubov.shopsphere.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ruhlanusubov.shopsphere.databinding.ItemProductBinding
import com.ruhlanusubov.shopsphere.model.product.Product
import com.ruhlanusubov.shopsphere.ui.home.HomeFragment
import com.ruhlanusubov.shopsphere.ui.home.HomeFragmentDirections
import com.ruhlanusubov.shopsphere.ui.home.detail.DetailsFragmentArgs

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    private val productList=ArrayList<Product>()

    inner class ProductHolder(val binding:ItemProductBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val layout=ItemProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductHolder(layout)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val item=productList[position]

        with(holder.binding){
            Glide.with(holder.itemView.context).load(item.thumbnail).into(image)
            productName.text=item.title
            brand.text=item.brand
            price.text="$${item.price}"
            cartProduct.setOnClickListener {
                it.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item))
            }
        }

    }
     fun updateList(list: List<Product>){
            productList.clear()
            productList.addAll(list)
            notifyDataSetChanged()
        }


}