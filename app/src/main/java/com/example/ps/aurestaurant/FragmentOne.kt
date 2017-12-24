package com.example.ps.aurestaurant

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.cell_home.view.*
import kotlinx.android.synthetic.main.fragment_fragment_one.*


/**
 * A simple [Fragment] subclass.
 */
class FragmentOne : Fragment() {

    var restaurantList = ArrayList<Restaurant>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_fragment_one, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        testRestaurant()
    }

    fun testRestaurant(){
        restaurantList.add(Restaurant("ก๋วยเตี๋ยวเจ๊ปูจี๊ดจ๊าด", "Thai","In the galaxy far far away...", "021231234", arrayOf(R.drawable.noodle, R.drawable.noodle2), 13.609934, 100.834303))
        restaurantList.add(Restaurant("S&P", "Fusion", "Simply Delicious, our slogan", "023536333", arrayOf(R.drawable.sp, R.drawable.sp2, R.drawable.sp3) ,13.612361, 100.837798))

        var adapter = RestaurantAdapter(this.context, restaurantList)
        listView.adapter = adapter
    }

    inner class RestaurantAdapter: BaseAdapter {
        var resList = ArrayList<Restaurant>()
        var context: Context? = null
        constructor(context: Context, listOfRes: ArrayList<Restaurant>):super() {
            this.context = context
            this.resList = listOfRes
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var currentRes = resList[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                var view = inflater.inflate(R.layout.cell_home, null)
                view.resName.text = currentRes.name
                view.resType.text = currentRes.type
                view.resImage.setImageResource(currentRes.images!![0])
                view.resImage.setOnClickListener {
                    val intent = Intent(context, RestaurantActivity::class.java)
                    intent.putExtra("name", currentRes.name)
                    context!!.startActivity(intent)
                }
                return view

        }

        override fun getItem(position: Int): Any {
            return resList[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return resList.size
        }
    }

}