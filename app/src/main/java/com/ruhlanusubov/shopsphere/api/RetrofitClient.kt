package com.ruhlanusubov.shopsphere.api

import com.ruhlanusubov.shopsphere.service.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{

        fun getClient(baseUrl:String): Retrofit {

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }



    }
}