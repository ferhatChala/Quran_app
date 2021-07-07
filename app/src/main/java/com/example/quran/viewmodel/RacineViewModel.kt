package com.example.quran.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.quran.data.QuranDatabase
import com.example.quran.models.*
import com.example.quran.repository.*
import kotlinx.coroutines.flow.Flow

class RacineViewModel(application: Application) :  AndroidViewModel(application) {

    val readAllRacineData : LiveData<List<Racine>>
    val readAllVersetData : LiveData<List<Verset>>
    //val readAllWordsData : LiveData<List<QuranWord>>
    //val readAllSurahData : LiveData<List<Surah>>


    private val racineRepo : RacineRepository
    private val versetRepo : VersetRepository
    private val wordRepo : QuranWordRepository
    private val surahRepo : SurahRepository


    init {
        val racineDao = QuranDatabase.getDatabase(application).racineDao()
        val versetDao = QuranDatabase.getDatabase(application).versetDao()
        val wordDao = QuranDatabase.getDatabase(application).wordDao()
        val surahDao = QuranDatabase.getDatabase(application).surahDao()


        racineRepo = RacineRepository(racineDao)
        versetRepo = VersetRepository(versetDao)
        wordRepo = QuranWordRepository(wordDao)
        surahRepo = SurahRepository(surahDao)


        readAllRacineData = racineRepo.readAllData
        readAllVersetData = versetRepo.readAllData
       // readAllWordsData = wordRepo.readAllData
       // readAllSurahData = surahRepo.readAllData

    }

    fun searchRacine(racine:String): LiveData<List<Racine>> {
        return racineRepo.searchRacine(racine)
    }

    fun getWordByIdRacine(id:Int): LiveData<List<QuranWord>> {
        return wordRepo.getWordByIdRacine(id)
    }

    fun getVersetById(id:String): LiveData<Verset>{
        return versetRepo.getVersetById(id)
    }

    fun getSurahById(id:Int): LiveData<Surah>{
        return surahRepo.getVersetById(id)
    }
}