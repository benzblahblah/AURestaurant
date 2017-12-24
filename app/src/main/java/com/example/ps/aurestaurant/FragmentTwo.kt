package com.example.ps.aurestaurant

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.app.FragmentTransaction
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.widget.Toast
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_fragment_two.*


class FragmentTwo : Fragment(), OnMapReadyCallback {

    private var mMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_fragment_two, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView.onCreate(null)
        mapView.onResume()
        mapView.getMapAsync(this)

        testRestaurant()
    }


    override fun onMapReady(googleMap: GoogleMap) {
        MapsInitializer.initialize(context)
        mMap = googleMap
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL

        //เริ่มโชว์ตำแหน่งแถว abac เสมอ
        val latLng = LatLng(13.612254, 100.836798)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16f))

        for(i in 0..restaurantList.size-1) {
            var newRes = restaurantList[i]
                var resLocation = LatLng(newRes.location!!.latitude, newRes.location!!.longitude)
                googleMap.addMarker(MarkerOptions().position(resLocation).title(newRes.name).snippet(newRes.description))
        }

    }


    var restaurantList = ArrayList<Restaurant>()
    fun testRestaurant(){
        restaurantList.add(Restaurant("ก๋วยเตี๋ยวเจ๊ปูจี๊ดจ๊าด", "Thai","In the galaxy far far away...", "021231234", arrayOf(R.drawable.noodle, R.drawable.noodle2), 13.609934, 100.834303))
        restaurantList.add(Restaurant("S&P", "Fusion", "Simply Delicious, our slogan", "023536333", arrayOf(R.drawable.sp, R.drawable.sp2, R.drawable.sp3) ,13.612361, 100.837798))

    }


}// Required empty public constructor