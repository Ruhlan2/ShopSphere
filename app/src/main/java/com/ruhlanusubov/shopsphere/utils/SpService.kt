package com.ruhlanusubov.shopsphere.utils

import android.content.Context
import android.content.SharedPreferences

class SpService {
    companion object{

        fun preference(context: Context):SharedPreferences{
            return context.getSharedPreferences("User",Context.MODE_PRIVATE)
        }
    }

}