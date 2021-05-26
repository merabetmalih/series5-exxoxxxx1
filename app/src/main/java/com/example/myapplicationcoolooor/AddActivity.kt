package com.example.s05exo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val addLayout = findViewById<ConstraintLayout>(R.id.addContainer)
        val BGcolor = intent.extras?.get("color_value")

        addLayout.setBackgroundColor(BGcolor as Int)
    }
}