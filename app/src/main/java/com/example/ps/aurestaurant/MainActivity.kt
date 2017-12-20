package com.example.ps.aurestaurant

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.support.design.widget.NavigationView
import android.support.v4.app.NavUtils
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.support.design.widget.BottomNavigationView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    //ใส่ Action ของ Navigation bar ข้างล่าง
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_search -> {
                val fragment1 = FragmentOne()
                val fragmentTransaction1 = supportFragmentManager.beginTransaction()
                fragmentTransaction1.replace(R.id.fram, fragment1, "Fragment One")
                fragmentTransaction1.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_map -> {
                val fragment2 = FragmentTwo()
                val fragmentTransaction2 = supportFragmentManager.beginTransaction()
                fragmentTransaction2.replace(R.id.fram, fragment2, "FragmentTwo")  //create first framelayout with id fram in the activity where fragments will be displayed
                fragmentTransaction2.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Tool bar ข้างบน
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.setTitle("AU Restaurant")
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.inflateMenu(R.menu.menu_item)

        //Navigation bar ข้างล่าง
        val navigation = findViewById<View>(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment1 = FragmentOne()
        val fragmentTransaction1 = supportFragmentManager.beginTransaction()
        fragmentTransaction1.replace(R.id.fram, fragment1, "Fragment One")  //create first framelayout with id fram in the activity where fragments will be displayed
        fragmentTransaction1.commit()

        //Navigation drawer สไลด์มาจากข้างๆ
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //menuInflater.inflate(R.menu.navigation_drawer, menu) //setting
        menuInflater.inflate(R.menu.menu_item, menu)
        val item = menu!!.findItem(R.id.action_add)
        return true
        //super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //handle presses on the action bar items
        when (item.itemId) {
            R.id.action_add -> {
                startActivity(Intent(this, AddRestaurantActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}
