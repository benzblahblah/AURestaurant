package com.example.ps.aurestaurant

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.MapFragment
import android.app.FragmentTransaction
import com.google.android.gms.maps.SupportMapFragment


class FragmentTwo : Fragment(), OnMapReadyCallback {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_fragment_two, container, false)
    }


    override fun onMapReady(googleMap: GoogleMap) {

    }

}// Required empty public constructor