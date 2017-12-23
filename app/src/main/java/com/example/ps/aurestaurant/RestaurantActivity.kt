package com.example.ps.aurestaurant

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_restaurant.*
import me.relex.circleindicator.CircleIndicator
import java.util.*

class RestaurantActivity : AppCompatActivity() {

    private var mPager: ViewPager? = null
    private var resImages = arrayOf<Int>(R.drawable.a, R.drawable.b, R.drawable.c)
    private var imgList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.setTitle("Restaurant Name Here")
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)

        this.getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        this.getSupportActionBar()!!.setDisplayShowHomeEnabled(true)

        init()


        //ปุ่ม direction เปิิด google maps ให้จาก latlong
        mapBtn.setOnClickListener {
            //var url = "https://www.google.com/maps/dir/?api=1&destination=" + latLng.latitude + "," + latLng.longitude + "&travelmode=driving"
            var url = "https://www.google.com/maps/dir/?api=1&destination=" + "13.612361,100.837798" + "&travelmode=driving"
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

        }

        //ปุ่ม call
        callBtn.setOnClickListener {
            val number = "7777777777" //เบอร์
            val call = Uri.parse("tel:" + number)
            val surf = Intent(Intent.ACTION_DIAL, call)
            startActivity(surf)
        }

    }

    //for image slider
    private fun init() {
        //ไว้ add รูปเป็น array แบบ static เฉยๆ
        for (i in resImages.indices) {
            imgList.add(resImages[i])
        }
        mPager = findViewById<ViewPager>(R.id.pager)
        mPager!!.setAdapter(MyAdapter(this, imgList))
        val indicator = findViewById<CircleIndicator>(R.id.indicator)
        indicator.setViewPager(mPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.resmenu_item, menu) //ปุ่ม review

        //ลองใส่ condition ได้มั้ยว่าถ้าเป็น owner ให้โชว์อันล่างนี้แทน แต่ถ้า else ก็โชว์บน
        //menuInflater.inflate(R.menu.owner_item, menu) //ปุ่ม edit res
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //handle presses on the action bar items
        when (item.itemId) {
            R.id.action_review -> {
                startActivity(Intent(this, CommentActivity::class.java))
                return true
            }
            R.id.action_edit -> {
//                startActivity(Intent(this, EditRestaurantActivity::class.java))
//                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }




}
