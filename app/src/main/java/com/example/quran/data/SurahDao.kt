package com.example.quran.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.quran.models.Surah
import com.example.quran.models.Verset

@Dao
interface SurahDao {
    @Query("SELECT * FROM Surah ORDER BY IdSourat ASC")
    fun readAllData(): LiveData<List<Surah>>

    @Query("SELECT * FROM Surah WHERE IdSourat =:id  ORDER BY IdSourat ASC")
    fun getSouratById(id:Int): LiveData<Surah>
}