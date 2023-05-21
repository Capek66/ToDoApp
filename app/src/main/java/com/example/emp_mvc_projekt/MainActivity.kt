package com.example.emp_mvc_projekt

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.example.core.entities.zadatak
import com.example.emp_mvc_projekt.data.DataRepository
import com.example.emp_mvc_projekt.data.LoadDataListener
import com.example.emp_mvc_projekt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LoadDataListener {
    private lateinit var binding : ActivityMainBinding

    private lateinit var zadaci : List<zadatak>
    private lateinit var lwZadaci : ListView
    private lateinit var btnZadaci : Button
    private lateinit var arrayAdapter : ArrayAdapter<zadatak>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ucitajZadatke()


        lwZadaci = findViewById<ListView>(R.id.lw_zadaci)
        btnZadaci = findViewById<Button>(R.id.btn_dodaj_zadatak)

        btnZadaci.setOnClickListener {
            dodajZadatak(it)
        }

        obnoviZadatke()

        lwZadaci.setOnItemClickListener(AdapterView.OnItemClickListener(
            fun (
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ): Unit{
                ukloniZadatak(position)
            }
        ))
    }

    private fun ucitajZadatke(){
        DataRepository().loadData(this, this)
    }

    private fun dodajZadatak(view : View){
        val unosZadatka : EditText
        unosZadatka = findViewById(R.id.et_dodaj_zadatak)
        val zadatak : String
        zadatak = unosZadatka.text.toString()

        if(!zadatak.isNullOrBlank()){
            val noviZadatak : zadatak = zadatak()
            noviZadatak.zadatak = zadatak
            DataRepository().insertData(this, this, noviZadatak)
            unosZadatka.text.clear()
        }else{
            Toast.makeText(applicationContext, "Unesite zadatak.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun ukloniZadatak(position : Int) {
        val context : Context
        context = applicationContext
        Toast.makeText(applicationContext, "Zadatak uklonjen.", Toast.LENGTH_SHORT).show()
        val obrisiZadatak : zadatak = zadaci.get(position)
        DataRepository().deleteData(this, this, obrisiZadatak)
    }

    override fun onDataLoaded(zadaci: List<zadatak>) {
        this.zadaci = zadaci
    }

    override fun onDataInserted(brojUnosa: List<Long>) {
        ucitajZadatke()
        obnoviZadatke()
    }

    override fun onDataDeleted(brojObrisanih: Int) {
        ucitajZadatke()
        obnoviZadatke()
    }

    private fun obnoviZadatke(){
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, zadaci)
        lwZadaci.adapter = arrayAdapter
    }
}