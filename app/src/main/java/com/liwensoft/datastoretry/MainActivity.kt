package com.liwensoft.datastoretry

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.liwensoft.datastoretry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //define dataStore
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "Study")
    //define key
    private val key = stringPreferencesKey("name")
    private val countkey = stringPreferencesKey("COUNT-KEY")
    private lateinit var tv: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("ACTIVITY", "ACTIVITY1 onCreate")

        tv=findViewById<TextView>(R.id.textView)

        val btn_put: Button = findViewById(R.id.btn_put)
        btn_put.setOnClickListener {
            Log.i("ACTIVITY", "ACTIVITY1 btn put")
            EasyDataStore.putData("name", "at home")
        }

        val btn_get: Button = findViewById(R.id.btn_get)
        btn_get.setOnClickListener {
            Log.i("ACTIVITY", "ACTIVITY1 btn get")
            val data = EasyDataStore.getData("name", "office")
            tv.setText(data)
        }

        val btn_clear: Button = findViewById(R.id.btn_clear)
        btn_clear.setOnClickListener {
            Log.i("ACTIVITY", "ACTIVITY1 btn clear")
            EasyDataStore.clearData()
        }


    }
}