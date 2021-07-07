package com.example.quran.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "QuranWord")
data class QuranWord(
    @PrimaryKey(autoGenerate = false)
    val ID_Word:Int,
    val Id_Aya:String,
    val idRacine:Int,
    val ArabicWord :String,
    val englishWord :String
): Parcelable