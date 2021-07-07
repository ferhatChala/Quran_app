package com.example.quran.retrofit

import retrofit2.Call
import com.example.quran.models.TafssirModel
import retrofit2.http.GET
import retrofit2.http.Path

interface APITafssirInterface {
    @GET("/tafseer/1/{sura_number}/{ayah_number}")
    fun getTafssir(
        @Path("sura_number") sura_number:Int,
        @Path("ayah_number") ayah_number:Int
    ): Call<TafssirModel>

}