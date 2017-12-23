package com.example.ps.aurestaurant

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.RatingBar
import kotlinx.android.synthetic.main.activity_comment.*

class CommentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.setTitle("Leave a Comment")
        toolbar.setTitleTextColor(Color.WHITE)

        val star = findViewById<View>(R.id.ratingBar)
        star.bringToFront() //ไม่งั้นกดไม่ได้เพราะช่องคอมเม้นบัง

        setSupportActionBar(toolbar)
        this.getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        this.getSupportActionBar()!!.setHomeAsUpIndicator(R.drawable.ic_close_black_24dp)

        //show เลขจาก rating bar เฉยๆ
        ratingBar.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener{
            ratingBar, rating, fromUser -> showRate.text = "$rating"

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish() // close this activity as oppose to navigating up
        return false
    }

}
