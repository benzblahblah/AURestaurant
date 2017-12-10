package com.example.ps.aurestaurant

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.View

class AddRestaurantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_restaurant)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.setTitle("New Restaurant")
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)

        this.getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        this.getSupportActionBar()!!.setHomeAsUpIndicator(R.drawable.ic_close_black_24dp)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish() // close this activity as oppose to navigating up
        return false
    }

}
