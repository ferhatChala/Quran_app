package com.example.quran.models

import java.io.Serializable

class TafssirModel(
    val tafsser_id:Int,
    val tafsser_name:String,
    val ayah_url:String,
    val ayah_number:Int,
    val text:String
): Serializable {

}