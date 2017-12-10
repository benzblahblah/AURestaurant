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
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.setTitle("AU Restaurant")
        toolbar.setTitleTextColor(Color.WHITE)


        toolbar.inflateMenu(R.menu.menu_item)
        searchView.setQueryHint("e.g. Chinese, Dessert")

        //val actionBar = supportActionBar
        //actionBar!!.setDisplayHomeAsUpEnabled(true) // Back Button <-

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
