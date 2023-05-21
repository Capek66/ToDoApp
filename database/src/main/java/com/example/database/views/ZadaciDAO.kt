package com.example.database.views

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.entities.zadatak

@Dao
interface ZadaciDAO {
    @Query("SELECT * FROM zadaci")
    fun dohvatiZadatke() : List<com.example.core.entities.zadatak>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertZadatak(vararg zadatak : zadatak) : List<Long>

    @Delete
    fun deleteZadatak(vararg zadatak : zadatak) : Int
}