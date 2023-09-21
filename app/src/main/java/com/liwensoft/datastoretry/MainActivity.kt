package com.liwensoft.datastoretry

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

class MainActivity : AppCompatActivity() {

    //define dataStore
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "Study")

    private lateinit var tv: TextView
    private lateinit var et:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        Log.i("ACTIVITY", "ACTIVITY1 onCreate")
        et=findViewById(R.id.number)
        tv=findViewById(R.id.textView)

        val btn_put: Button = findViewById(R.id.btn_put)
        btn_put.setOnClickListener {
            Log.i("ACTIVITY", "ACTIVITY1 btn put")
            EasyDataStore.putData("name", "at home")
            var num:Int
            try {
                num = et.text.toString().toInt()
            }
            catch (ex: Exception)
            {
                num=2
            }
            EasyDataStore.putData( "count", num)
        }

        val btn_get: Button = findViewById(R.id.btn_get)
        btn_get.setOnClickListener {
            Log.i("ACTIVITY", "ACTIVITY1 btn get")
            val sdata = EasyDataStore.getData("name", "office")
            val idata = EasyDataStore.getData( "count", 5)
            val data="name={$sdata} count={$idata}"
            tv.setText(data)
        }

        val btn_clear: Button = findViewById(R.id.btn_clear)
        btn_clear.setOnClickListener {
            Log.i("ACTIVITY", "ACTIVITY1 btn clear")
            EasyDataStore.clearData()
        }

    }
}