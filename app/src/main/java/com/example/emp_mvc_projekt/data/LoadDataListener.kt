package com.example.emp_mvc_projekt.data

import com.example.core.entities.zadatak

interface LoadDataListener {
    fun onDataLoaded(zadaci : List<zadatak>)
    fun onDataInserted(brojUnosa : List<Long>)
    fun onDataDeleted(brojObrisanih : Int)
}