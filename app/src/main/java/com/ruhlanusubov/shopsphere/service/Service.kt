package com.ruhlanusubov.shopsphere.service

import com.ruhlanusubov.shopsphere.model.category.Category
import com.ruhlanusubov.shopsphere.model.product.Product
import com.ruhlanusubov.shopsphere.model.product.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("products")
    fun getProduct():Call<ProductResponse>

    @GET("products")
    fun topBrands(
        @Query("select") select:String,
        @Query("limit") limit:Int
    ):Call<ProductResponse>
    @GET("products/categories")
    fun getCategory():Call<Category>


}