package com.ruhlanusubov.shopsphere.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruhlanusubov.shopsphere.databinding.ItemCategoryBinding

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    private val categoryList=ArrayList<String>()
    inner class CategoryHolder(val binding: ItemCategoryBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val layout=ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryHolder(layout)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val item=categoryList[position]
        holder.binding.categoryType.text=item

    }
    fun updateList(list: List<String>){
        categoryList.clear()
        categoryList.addAll(list)
        notifyDataSetChanged()
    }
}