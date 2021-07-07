package com.example.quran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.quran.fragments.*
import com.google.android.material.navigation.NavigationView

class MainActivity2 : AppCompatActivity() {
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)
        navController = Navigation.findNavController(this,R.id.nav_host_fragment)

        //les fragments

        val indexFragment = IndexFragment()
        val ayatListFragment = AyatListFragment()

        val favoriteFragment = FavoriteFragment()

        val settingFragment = SettingFragment()





        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_index -> supportFragmentManager.beginTransaction().replace(R.id.mainContainer,indexFragment).commit()
                R.id.nav_ayatlist -> supportFragmentManager.beginTransaction().replace(R.id.mainContainer,ayatListFragment).commit()
                R.id.nav_favorite -> supportFragmentManager.beginTransaction().replace(R.id.mainContainer,favoriteFragment).commit()
                R.id.nav_settings -> supportFragmentManager.beginTransaction().replace(R.id.mainContainer,settingFragment).commit()
                // R.id.nav_login -> supportFragmentManager.beginTransaction().replace(R.id.mainContainer,rootFragment).commit()
                // R.id.nav_share -> supportFragmentManager.beginTransaction().replace(R.id.mainContainer,rootFragment).commit()

            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}