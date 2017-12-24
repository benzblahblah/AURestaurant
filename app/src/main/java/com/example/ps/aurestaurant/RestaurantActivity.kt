package com.example.ps.aurestaurant

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.*
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_restaurant.*
import kotlinx.android.synthetic.main.cell_restaurant.view.*
import me.relex.circleindicator.CircleIndicator
import java.util.*

class RestaurantActivity : AppCompatActivity() {

    private var mPager: ViewPager? = null
    private var resImages = arrayOf<Int>(R.drawable.pizza, R.drawable.noodle, R.drawable.sp)
    private var imgList = ArrayList<Int>()
    var commentList = ArrayList<Comment>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        val extras = intent.extras
        var name = extras.getString("name")


        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.setTitle("$name")
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)

        this.getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        this.getSupportActionBar()!!.setDisplayShowHomeEnabled(true)

        init()
        btnAction()
        testComment()

    }

    fun btnAction(){
        val restaurantname = "Passed Restaurant Name"
        menuBtn.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("name", restaurantname)
            startActivity(intent)
        }

        //ปุ่ม direction เปิิด google maps ให้จาก latlong
        mapBtn.setOnClickListener {
            //var url = "https://www.google.com/maps/dir/?api=1&destination=" + latLng.latitude + "," + latLng.longitude + "&travelmode=driving"
            var url = "https://www.google.com/maps/dir/?api=1&destination=" + "13.612361,100.837798" + "&travelmode=driving" // <--- ใส่ latlong ตรงกลาง
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

        }

        //ปุ่ม call
        callBtn.setOnClickListener {
            val number = "0866663967" //เบอร์ใส่ตรงนี้
            val call = Uri.parse("tel:" + number)
            val surf = Intent(Intent.ACTION_DIAL, call)
            startActivity(surf)
        }

    }

    //สำหรับ image slider
    private fun init() {
        //ไว้ add รูปจาก resImages เป็น array แบบ static เฉยๆ
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



    fun testComment(){
        commentList.add(Comment(4.5f, "Delicious","Maxwell"))
        commentList.add(Comment(3.0f, "Wait forever, cold foods, goodbye ja", "Steve"))

        var adapter = CommentAdapter(this, commentList)
        reviewList.adapter = adapter
    }

    inner class CommentAdapter: BaseAdapter {
        var comList = ArrayList<Comment>()
        var context: Context? = null
        constructor(context: Context, listOfComment: ArrayList<Comment>):super() {
            this.context = context
            this.comList = listOfComment
        }

        //bind data to list view
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var currentCom = comList[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            var view = inflater.inflate(R.layout.cell_restaurant, null)
            view.userName.text = currentCom.user
            view.comment.text = currentCom.comment
            view.resRating.rating = currentCom.rate!! //เอาค่ามาใส่ rating bar ต้องเป็น float เสมอ
            return view

        }

        override fun getItem(position: Int): Any {
            return comList[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return comList.size
        }
    }


}
