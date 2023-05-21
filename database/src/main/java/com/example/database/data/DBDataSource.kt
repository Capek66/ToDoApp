package com.example.database.data

import android.content.Context
import com.example.core.helpers.DataSourceListener
import com.example.database.entities.zadatak
import com.example.database.views.MainDatabase
import com.example.database.views.ZadaciDAO

class DBDataSource(context : Context) : com.example.core.helpers.DataSource {
    var dao : ZadaciDAO

    init{
        dao = MainDatabase.getInstance(context).getDao()
    }

    fun getZadaci(): List<com.example.core.entities.zadatak> {
        return dao.dohvatiZadatke()
    }

    override fun loadData(listener: DataSourceListener, context: Context) {
        listener.onDataLoaded(getZadaci())
    }

    fun insertZadatak(zadatak : com.example.core.entities.zadatak): List<Long> {
        val zadatakdao : zadatak = zadatak()
        zadatakdao.zadatak = zadatak.zadatak
        return dao.insertZadatak(zadatakdao)
    }

    override fun insertData(listener: DataSourceListener, context: Context, zadatak : com.example.core.entities.zadatak) {
        listener.onDataInserted(insertZadatak(zadatak))
    }

    fun deleteZadatak(zadatak : com.example.core.entities.zadatak): Int {
        val zadatakdao : zadatak = zadatak()
        zadatakdao.id = zadatak.id
        zadatakdao.zadatak = zadatak.zadatak
        return dao.deleteZadatak(zadatakdao)
    }

    override fun deleteData(
        listener: DataSourceListener,
        context: Context,
        zadatak: com.example.core.entities.zadatak
    ) {
        listener.onDataDeleted(deleteZadatak(zadatak))
    }
}