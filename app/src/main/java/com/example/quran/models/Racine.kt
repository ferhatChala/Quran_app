package com.example.quran.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Racine")
data class Racine(
    @PrimaryKey(autoGenerate = false)
    val idRacine:Int,
    val Racine :String,
    val NBLettre :Int
): Parcelable