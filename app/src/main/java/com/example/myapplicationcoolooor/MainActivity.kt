 package com.example.s05exo5

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import yuku.ambilwarna.AmbilWarnaDialog
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private var defaultColor by Delegates.notNull<Int>()

    private lateinit var mainContainer: ConstraintLayout
    private lateinit var addContainer: ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val home = findViewById<ImageView>(R.id.homePage) 
        val addAct = findViewById<ImageView>(R.id.addPage)
        val setting = findViewById<ImageView>(R.id.setting)




        mainContainer = findViewById(R.id.mainContainer)
        val button  = findViewById<Button>(R.id.button)
        defaultColor = ContextCompat.getColor(this, R.color.purple_200)


        loadData()

        button.setOnClickListener {
            openColorPicker()

        }



        setting.setOnClickListener {
            val intent = Intent(this,SettingActivity::class.java)
            intent.putExtra("color_value",defaultColor)
            startActivity(intent)
        }

        addAct.setOnClickListener {
            val intent = Intent(this,AddActivity::class.java)
            intent.putExtra("color_value",defaultColor)
            startActivity(intent)
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
    private fun loadData() {

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedInt = sharedPreferences.getInt("INT_KEY",defaultColor)
        defaultColor = savedInt
        mainContainer.setBackgroundColor(savedInt)
    }

    private fun saveData() {

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putInt("INT_KEY",defaultColor)

        }.apply()
        Toast.makeText(this,"Data Saved", Toast.LENGTH_SHORT).show()
    }
}