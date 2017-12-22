package com.example.ps.aurestaurant
import android.location.Location
/**
 * Created by PS on 23/12/2017 AD.
 */
class Restaurant {
    var name:String? = null
    var description:String? = null
    var image: Int? = null
    var location:Location? = null


    constructor(name: String?, description: String?, image: Int?, latitude: Double?, longitude:Double?) {
        this.name = name
        this.description = description
        this.image = image
        this.location = Location(name)
        this.location!!.latitude = latitude!!
        this.location!!.longitude = longitude!!

    }


}