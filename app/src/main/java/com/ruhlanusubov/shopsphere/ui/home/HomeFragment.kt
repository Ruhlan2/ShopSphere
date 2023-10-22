package com.ruhlanusubov.shopsphere.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruhlanusubov.shopsphere.R
import com.ruhlanusubov.shopsphere.adapter.BrandAdapter
import com.ruhlanusubov.shopsphere.adapter.CategoryAdapter
import com.ruhlanusubov.shopsphere.api.ApiUtil
import com.ruhlanusubov.shopsphere.databinding.FragmentHomeBinding
import com.ruhlanusubov.shopsphere.model.category.Category
import com.ruhlanusubov.shopsphere.model.product.Product
import com.ruhlanusubov.shopsphere.model.product.ProductResponse
import com.ruhlanusubov.shopsphere.utils.Constants.LIMIT
import com.ruhlanusubov.shopsphere.utils.Constants.SELECT
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
     private var _binding:FragmentHomeBinding?=null
     private val binding get() = _binding!!
     private val service=ApiUtil.getService()
     private val category=CategoryAdapter()
     private val brand=BrandAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding= FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryData()
        brandData()
        categoryAdapter()
        brandAdapter()
    }
    private fun brandData(){

        service.topBrands(SELECT, LIMIT).enqueue(object :Callback<ProductResponse>{
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        brand.updateList(it.products?: emptyList())
                    }
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                FancyToast.makeText(requireContext(),t.localizedMessage,FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show()
            }

        })
    }
    private fun categoryData(){

        service.getCategory().enqueue(object :Callback<Category>{
            override fun onResponse(call: Call<Category>, response: Response<Category>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        category.updateList(it)
                    }
                }
            }

            override fun onFailure(call: Call<Category>, t: Throwable) {

                FancyToast.makeText(requireContext(),t.localizedMessage,FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show()
            }

        })
    }
    private fun categoryAdapter(){
        with(binding.categoryRv){
            layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter=category
        }
    }
    private fun brandAdapter(){
        with(binding.brandRv){
            layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter=brand
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}