package com.example.quran.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Surah")
data class Surah(
    @PrimaryKey(autoGenerate = false)
    val IdSourat:Int,
    val NomSourat :String,
    val Location :String,
    val NbrAyat :Int,
    val NbrMots :Int,
    val NbrLettre :Int
): Parcelable