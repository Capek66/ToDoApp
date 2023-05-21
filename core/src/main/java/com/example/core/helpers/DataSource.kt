package com.example.core.helpers

import android.content.Context
import com.example.core.entities.zadatak

interface DataSource {
    fun loadData(listener: DataSourceListener, context: Context)
    fun insertData(listener: DataSourceListener, context: Context, zadatak : zadatak)
    fun deleteData(listener: DataSourceListener, context: Context, zadatak : zadatak)
}