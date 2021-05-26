package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {
    private var defaultColor by Delegates.notNull<Int>()
    val SHARED_PREFS = "sharedPreds"
    val PRIMCOL="PRIME"
    val SECOL="SECOND"
    private lateinit var mainContainer: ConstraintLayout

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        defaultColor = ContextCompat.getColor(this, R.color.purple_200)
        mainContainer =findViewById(R.id.maincontainer)
        loadData()
        val v= findViewById<View>(android.R.id.content)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.action_settings -> {
                val i = Intent(this,SettingsActivity::class.java)
                startActivity(i)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun loadData() {

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedInt = sharedPreferences.getInt("INT_KEY",defaultColor)
        defaultColor = savedInt
        mainContainer.setBackgroundColor(savedInt)
    }

}