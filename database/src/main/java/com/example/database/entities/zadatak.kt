package com.example.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "zadaci", primaryKeys = ["id"])
class zadatak () : com.example.core.entities.zadatak() {
    @PrimaryKey(autoGenerate = true)
    @Ignore
    override var id : Int? = null

    @Ignore
    override var zadatak : String = ""
}