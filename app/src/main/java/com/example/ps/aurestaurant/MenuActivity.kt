package com.example.ps.aurestaurant

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.cell_menu.view.*
import java.util.ArrayList

class MenuActivity : AppCompatActivity() {

    var menuList = ArrayList<MenuRes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.setTitle("Menu") //($resName Menu)
        toolbar.setTitleTextColor(Color.WHITE)

        setSupportActionBar(toolbar)
        this.getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        this.getSupportActionBar()!!.setHomeAsUpIndicator(R.drawable.ic_close_black_24dp)

        testMenu()
    }

    fun testMenu(){
        menuList.add(MenuRes("Pizza", 249, R.drawable.pizza))
        menuList.add(MenuRes("Fried Chicken", 29, R.drawable.chicken))

        var adapter = MenuAdapter(this, menuList)
        listView.adapter = adapter
    }

    inner class MenuAdapter: BaseAdapter {
        var menList = ArrayList<MenuRes>()
        var context: Context? = null
        constructor(context: Context, listOfMenu: ArrayList<MenuRes>):super() {
            this.context = context
            this.menList = listOfMenu
        }

        //bind data to list view
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var currentMenu = menList[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            var view = inflater.inflate(R.layout.cell_menu, null)
            view.foodName.text = currentMenu.name
            view.foodPrice.text = currentMenu.price.toString() + " THB"
            view.foodImage.setImageResource(currentMenu.foodimg!!)
            return view

        }

        override fun getItem(position: Int): Any {
            return menList[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return menList.size
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish() // close this activity as oppose to navigating up
        return false
    }
}
