package com.example.database.views

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.database.entities.zadatak

@Database(version = 1, entities = [zadatak::class], exportSchema = false)
abstract class MainDatabase : RoomDatabase() {
    abstract fun getDao(): ZadaciDAO

    companion object
    {
        private var instance : MainDatabase? = null

        fun getInstance(context : Context) : MainDatabase
        {
            if (instance == null)
            {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java, "main.db"
                ).allowMainThreadQueries().build()
            }

            return instance as MainDatabase
        }
    }
}