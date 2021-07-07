package com.example.quran.repository

import androidx.lifecycle.LiveData
import com.example.quran.data.VersetDao
import com.example.quran.models.QuranWord
import com.example.quran.models.Verset

class VersetRepository(private val versetDao: VersetDao) {
    val readAllData: LiveData<List<Verset>> = versetDao.readAllData()

    fun getVersetById(id:String): LiveData<Verset>{
        return versetDao.getVersetById(id)
    }

}