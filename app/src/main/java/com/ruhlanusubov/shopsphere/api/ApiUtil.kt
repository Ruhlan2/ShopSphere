package com.ruhlanusubov.shopsphere.api

import com.ruhlanusubov.shopsphere.service.Service
import com.ruhlanusubov.shopsphere.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiUtil {
    companion object{
     fun getService():Service{
         return RetrofitClient.getClient(BASE_URL).create(Service::class.java)
     }
    }
}