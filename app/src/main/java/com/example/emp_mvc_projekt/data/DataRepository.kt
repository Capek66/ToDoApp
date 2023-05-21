package com.example.emp_mvc_projekt.data

import android.content.Context
import com.example.core.entities.zadatak
import com.example.core.helpers.DataSource
import com.example.core.helpers.DataSourceListener
import com.example.database.data.DBDataSource

class DataRepository {
    fun loadData(context : Context, listener: LoadDataListener)
    {
        var dataSource : DataSource
        dataSource = DBDataSource(context)

        dataSource.loadData(object : DataSourceListener {
            override fun onDataLoaded(zadaci: List<zadatak>) {
                listener.onDataLoaded(zadaci)
            }

            override fun onDataInserted(brojUnosa: List<Long>) {
                TODO("Not yet implemented")
            }

            override fun onDataDeleted(brojObrisanih: Int) {
                TODO("Not yet implemented")
            }
        }, context)
    }

    fun insertData(context : Context, listener: LoadDataListener, zadatak: zadatak)
    {
        var dataSource : DataSource
        dataSource = DBDataSource(context)

        dataSource.insertData(object : DataSourceListener {
            override fun onDataLoaded(zadaci: List<zadatak>) {
                TODO("Not yet implemented")
            }

            override fun onDataInserted(brojUnosa: List<Long>) {
                listener.onDataInserted(brojUnosa)
            }

            override fun onDataDeleted(brojObrisanih: Int) {
                TODO("Not yet implemented")
            }

        }, context, zadatak)
    }

    fun deleteData(context : Context, listener: LoadDataListener, zadatak: zadatak)
    {
        var dataSource : DataSource
        dataSource = DBDataSource(context)

        dataSource.deleteData(object : DataSourceListener {
            override fun onDataLoaded(zadaci: List<zadatak>) {
                TODO("Not yet implemented")
            }

            override fun onDataInserted(brojUnosa: List<Long>) {
                TODO("Not yet implemented")
            }

            override fun onDataDeleted(brojObrisanih: Int) {
                listener.onDataDeleted(brojObrisanih)
            }

        }, context, zadatak)
    }
}