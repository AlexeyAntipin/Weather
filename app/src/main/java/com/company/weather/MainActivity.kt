package com.company.weather

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.company.weather.view_models.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var temp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        temp = findViewById(R.id.temp)

        val viewModel by viewModels<MainActivityViewModel>()
        viewModel.getProgressState().observe(this, Observer {
            temp.text = it.toString()
        })

        viewModel.getData("Moscow")
    }
}