package com.project.semester7cw.GoogleMaps.GeoCoding

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.project.semester7cw.R

class GeoCodingMain : AppCompatActivity() {
    lateinit var etAddress: EditText
    lateinit var btFindLtLg: Button
    lateinit var  tvLatitide: TextView
    lateinit var tvLongitude: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geo_coding_main)

        etAddress = findViewById(R.id.etAddress)
        btFindLtLg = findViewById(R.id.btFindLtLg)
        tvLatitide = findViewById(R.id.tvLatitide)
        tvLongitude = findViewById(R.id.tvLongitude)

        btFindLtLg.setOnClickListener {
            if(etAddress.text.toString().isEmpty()) {
                Toast.makeText(this, "No location provided", Toast.LENGTH_SHORT).show()
            }
            else {
                getLocationFromAddress(etAddress.text.toString())
            }
        }
    }

    private fun getLocationFromAddress(location: String) {
        val geoCoder = Geocoder(this)
        val list: List<Address> = geoCoder.getFromLocationName(location, 5)!!
        if(list.isNullOrEmpty()) {
            return
        }
        tvLatitide.text = "Latitude: ${list[0].latitude}"
        tvLongitude.text = "Latitude: ${list[0].longitude}"
    }
}