package com.example.quran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import androidx.navigation.fragment.findNavController
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.quran.fragments.*
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this@MainActivity,MainActivity2::class.java)
            startActivity(intent)
            finish()
        },3000)

    }

}