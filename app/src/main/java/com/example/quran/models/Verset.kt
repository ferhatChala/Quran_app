package com.example.quran.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(foreignKeys = [ForeignKey(entity = Surah::class,parentColumns = ["IdSourat"],childColumns = ["IdSourat"])
])
class Verset(
   @PrimaryKey(autoGenerate = false)
   val IdAya:String,
   val IdSourat:Int,
   val NumAya:Int,
   val Text_AR:String,
   val nbMots:Int
): Parcelable