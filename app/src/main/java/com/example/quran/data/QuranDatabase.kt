package com.example.quran.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quran.models.*


@Database(
    entities = [QuranWord::class,Racine::class, Surah::class,Verset::class],
    version = 1,
    exportSchema = false
)
abstract class QuranDatabase() : RoomDatabase() {
    abstract fun racineDao():RacineDao
    abstract fun versetDao():VersetDao
    abstract fun wordDao():QuranWordDao
    abstract fun surahDao():SurahDao

    companion object{
        @Volatile
        private var INSTANCE : QuranDatabase?=null

        fun getDatabase(context: Context):QuranDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuranDatabase::class.java,
                    "Quran_db"
                ).createFromAsset("QuranDB.db").build()
                INSTANCE = instance
                return  instance
            }
        }
    }
}