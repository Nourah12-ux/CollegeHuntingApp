package com.example.nourah_alhindi_retake1.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UniversityTable::class], version = 1, exportSchema = false)
abstract class UniversitiesDatabase:RoomDatabase() {
    abstract fun universitiesDao():UniversitiesDao
    companion object{
        @Volatile
        private var Instance:UniversitiesDatabase?=null

        fun getDatabase(context: Context):UniversitiesDatabase{
            val ItemInctance= Instance
            if (ItemInctance!=null) {
                return ItemInctance
            }
            synchronized(this){  // protection from concurrent execution on multiple threads
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UniversitiesDatabase::class.java,
                    "University_Table"
                ).fallbackToDestructiveMigration()  // Destroys old database on version change
                    .build()
                Instance = instance
                return instance
            }
        }
    }


}