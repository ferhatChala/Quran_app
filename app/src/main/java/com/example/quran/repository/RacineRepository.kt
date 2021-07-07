package com.example.quran.repository

import androidx.lifecycle.LiveData
import com.example.quran.data.RacineDao
import com.example.quran.models.Racine
import kotlinx.coroutines.flow.Flow

class RacineRepository(private val racineDao: RacineDao) {
        val readAllData: LiveData<List<Racine>> = racineDao.readAllData()

        fun searchRacine(racine:String): LiveData<List<Racine>>{
                return racineDao.searchRacine(racine)
        }
}