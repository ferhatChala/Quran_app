package com.example.quran.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.quran.models.QuranWord


@Dao
interface QuranWordDao {
    @Query("SELECT * FROM QuranWord ORDER BY ID_Word ASC")
    fun readAllData(): LiveData<List<QuranWord>>

    @Query("SELECT * FROM QuranWord WHERE idRacine=:id ORDER BY ID_Word ASC")
    fun getWordByIdRacine(id:Int):LiveData<List<QuranWord>>

}