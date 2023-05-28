package com.example.parcialtp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class BottomNavigationActivity : AppCompatActivity() {

//    private lateinit var nav_host : NavHostFragment
//    private lateinit var bottomNav: BottomNavigationView

    private lateinit var nav_host_drawer: NavHostFragment
    private lateinit var drawer_layout: DrawerLayout
    private lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)


        // navegacion de botonera
//        nav_host = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
//        bottomNav = findViewById(R.id.bottom_bar)
//        NavigationUI.setupWithNavController(bottomNav, nav_host.navController)

        // NAVEGACION HAMBURGESITA

        drawer_layout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        nav_host_drawer= supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment

       setupDrawerLayout()




    }

    private fun setupDrawerLayout(){
        val navController = nav_host_drawer.navController
        navigationView.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout)

        navController.addOnDestinationChangedListener{_,_,_ ->
            supportActionBar?.setHomeAsUpIndicator(R.drawable.icon_option)
        }



    }

}