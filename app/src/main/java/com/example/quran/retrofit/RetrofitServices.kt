package com.example.quran.retrofit

import com.example.quran.retrofit.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServices {


    val RETROFIT_TAFSSIR_ENDPOINT :APITafssirInterface by lazy {
        Retrofit.Builder().baseUrl(Constants.URL_API_Tafssir). addConverterFactory(
            GsonConverterFactory.create()). build().create(APITafssirInterface::class.java)
    }
}