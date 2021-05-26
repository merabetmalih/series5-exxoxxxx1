package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceFragmentCompat
import kotlinx.android.synthetic.main.settings_activity.*
import yuku.ambilwarna.AmbilWarnaDialog
import kotlin.properties.Delegates

class SettingsActivity : AppCompatActivity() {
    private var defaultColor by Delegates.notNull<Int>()
    private lateinit var mainContainer: ConstraintLayout
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        mainContainer = findViewById(R.id.settingscontainer)
        defaultColor = ContextCompat.getColor(this, R.color.purple_200)
        loadData()
        button10.setOnClickListener {

            openColorPicker()

        }
        button11.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
    private fun openColorPicker() {
        var colorPicker : AmbilWarnaDialog =  AmbilWarnaDialog(this,defaultColor,object : AmbilWarnaDialog.OnAmbilWarnaListener{

            override fun onCancel(dialog: AmbilWarnaDialog?){
            }

            override fun onOk(dialog: AmbilWarnaDialog?, color:Int){

                defaultColor = color
                saveData()
                mainContainer.setBackgroundColor(defaultColor)
            }
        })
        colorPicker.show()
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }
    }
    private fun saveData() {

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putInt("INT_KEY",defaultColor)

        }.apply()
        Toast.makeText(this,"Data Saved", Toast.LENGTH_SHORT).show()
    }
    private fun loadData() {

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedInt = sharedPreferences.getInt("INT_KEY",defaultColor)
        defaultColor = savedInt
        mainContainer.setBackgroundColor(savedInt)
    }
}