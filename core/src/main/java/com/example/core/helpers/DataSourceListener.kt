package com.example.core.helpers

import com.example.core.entities.zadatak

interface DataSourceListener {
    fun onDataLoaded(zadaci: List<zadatak>)
    fun onDataInserted(brojUnosa : List<Long>)
    fun onDataDeleted(brojObrisanih : Int)
}