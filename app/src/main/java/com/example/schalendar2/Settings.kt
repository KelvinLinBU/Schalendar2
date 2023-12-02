package com.example.schalendar2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.settings)
        super.onCreate(savedInstanceState)
        val colorspinner: Spinner = findViewById(R.id.colorspinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.menu_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            colorspinner.adapter = adapter
        }
        val languagespinner: Spinner = findViewById(R.id.languagespinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.menu_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            languagespinner.adapter = adapter
        }
    }
}