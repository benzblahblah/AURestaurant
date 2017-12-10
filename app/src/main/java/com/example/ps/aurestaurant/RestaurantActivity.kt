//package com.example.ps.aurestaurant
//
//import android.content.Context
//import android.graphics.Color
//import android.support.v7.app.AppCompatActivity
//import android.os.Bundle
//import android.support.v4.view.PagerAdapter
//import android.support.v7.widget.Toolbar
//import android.view.View
//import android.support.v4.view.ViewPager
//
//class RestaurantActivity : AppCompatActivity() {
//
//    private lateinit var mPager: ViewPager
//    var path: IntArray = intArrayOf() /////ใส่รูปสำหรับ slider
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_restaurant)
//
//        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
//        setSupportActionBar(toolbar)
//        toolbar.setTitle("") //ชื่อร้าน
//        toolbar.setTitleTextColor(Color.WHITE)
//        this.getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true) //back button
//
//        mPager = findViewById<ViewPager>(R.id.imageSlider)
//        var adapter: PagerAdapter = PageView(this,path)
//        mPager.adapter = adapter
//        mPager.addOnAdapterChangeListener(object : ViewPager.OnAdapterChangeListener{
//            override fun onPageScrollStateChanged(state: Int) {
//
//            }
//
//            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//
//            }
//
//            override fun onPageSelected(position: Int) {
//
//            }
//
//
//        })
//    }
//
//    inner class PageView: PagerAdapter{
//        override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
//
//        }
//
//        override fun getCount(): Int {
//
//        }
//
//
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        finish() // close this activity as oppose to navigating up
//        return false
//    }
//
//
//    //https://www.youtube.com/watch?v=XLCIOKQhV8o <<<< for slide image
//    //https://stackoverflow.com/questions/22704451/open-google-maps-through-intent-for-specific-location-in-android <<<< for map
//
//}
