package com.ruhlanusubov.shopsphere.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ruhlanusubov.shopsphere.databinding.ItemBrandBinding
import com.ruhlanusubov.shopsphere.model.product.Product

class BrandAdapter: RecyclerView.Adapter<BrandAdapter.BrandHolder>() {

    private val brandList=ArrayList<Product>()
    inner class BrandHolder(val binding:ItemBrandBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandHolder {
        val layout=ItemBrandBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BrandHolder(layout)
    }

    override fun getItemCount(): Int {
        return brandList.size
    }

    override fun onBindViewHolder(holder: BrandHolder, position: Int) {
        val item=brandList[position]
        with(holder.binding){
            brandName.text=item.brand
            Glide.with(holder.itemView.context).load(item.thumbnail).into(brandImg)
        }
    }
    fun updateList(list: List<Product>){
        brandList.clear()
        brandList.addAll(list)
        notifyDataSetChanged()
    }
}