package com.example.s05exo5

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import yuku.ambilwarna.AmbilWarnaDialog
import kotlin.properties.Delegates

@Suppress("UNREACHABLE_CODE")
class SettingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val settingLayout = findViewById<ConstraintLayout>(R.id.settingContainer)
        val BGcolor = intent.extras?.get("color_value")

        settingLayout.setBackgroundColor(BGcolor as Int)




    }



}