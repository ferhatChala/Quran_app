package com.example.quran.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.quran.models.Racine
import kotlinx.coroutines.flow.Flow

@Dao
interface RacineDao {
    @Query("SELECT * FROM Racine ORDER BY idRacine ASC")
    fun readAllData(): LiveData<List<Racine>>

    @Query("SELECT * FROM Racine WHERE Racine LIKE:racine")
    fun searchRacine(racine:String):LiveData<List<Racine>>

}