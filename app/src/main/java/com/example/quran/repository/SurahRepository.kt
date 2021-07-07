package com.example.quran.repository

import androidx.lifecycle.LiveData
import com.example.quran.data.SurahDao
import com.example.quran.models.Surah
import com.example.quran.models.Verset

class SurahRepository(private val  surahDao: SurahDao) {
    val readAllData: LiveData<List<Surah>> = surahDao.readAllData()

    fun getVersetById(id:Int): LiveData<Surah>{
        return surahDao.getSouratById(id)
    }
}