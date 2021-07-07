package com.example.quran.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.quran.models.QuranWord
import com.example.quran.models.Verset

@Dao
interface VersetDao {
    @Query("SELECT * FROM Verset ORDER BY IdSourat ASC")
    fun readAllData(): LiveData<List<Verset>>

    @Query("SELECT * FROM Verset WHERE IdAya =:id  ORDER BY IdSourat ASC")
    fun getVersetById(id:String): LiveData<Verset>
}