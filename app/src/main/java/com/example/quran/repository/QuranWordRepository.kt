package com.example.quran.repository

import androidx.lifecycle.LiveData
import com.example.quran.data.QuranWordDao
import com.example.quran.models.QuranWord
import com.example.quran.models.Racine


class QuranWordRepository(private  val quranWordDao: QuranWordDao) {
    val readAllData: LiveData<List<QuranWord>> = quranWordDao.readAllData()

    fun getWordByIdRacine(id:Int): LiveData<List<QuranWord>>{
        return quranWordDao.getWordByIdRacine(id)
    }
}