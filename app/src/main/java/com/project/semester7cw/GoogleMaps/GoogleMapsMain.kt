package com.project.semester7cw.GoogleMaps

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.media.audiofx.Equalizer.Settings
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.common.api.GoogleApi
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.project.semester7cw.R
import java.util.Locale

class GoogleMapsMain : AppCompatActivity() {
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    lateinit var tvLatitude: TextView
    lateinit var tvLongitude: TextView
    lateinit var tvCountryName: TextView
    lateinit var tvLocality: TextView
    lateinit var tvAddress: TextView
    lateinit var locationBtn: Button
    lateinit var mapBtn: Button
    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    private val permissionId = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_maps_main)

        tvLatitude = findViewById(R.id.textView3)
        tvLongitude = findViewById(R.id.textView4)
        tvCountryName = findViewById(R.id.textView5)
        tvLocality = findViewById(R.id.textView6)
        tvAddress = findViewById(R.id.textView7)
        mapBtn = findViewById(R.id.mapBtn)

        mapBtn.setOnClickListener {
            openMap()
        }

        locationBtn = findViewById(R.id.locationBtn)

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        locationBtn.setOnClickListener {
            getLocation()
        }
    }

    @SuppressLint("MissingPermission", "setTextI18n")
    private fun getLocation() {
        if(checkPermissions()) {
            if(isLocationEnabled()) {
                mFusedLocationClient.lastLocation.addOnSuccessListener {
                    location: Location? ->
                    location?.let {
                        val geocoder = Geocoder(this, Locale.getDefault())
                        val list: List<Address> = geocoder.getFromLocation(location.latitude, location.longitude, 1)!!
                        latitude = list[0].latitude
                        longitude = list[0].longitude
                        tvLatitude.text = "Latitude\n${list[0].latitude}"
                        tvLongitude.text = "Latitude\n${list[0].longitude}"
                        tvCountryName.text = "Latitude\n${list[0].countryName}"
                        tvLocality.text = "Latitude\n${list[0].locality}"
                        tvAddress.text = "Latitude\n${list[0].getAddressLine(0)}"
                    }
                }
            }
            else {
                Toast.makeText(this, "Location to on kar be", Toast.LENGTH_SHORT).show()
                val intent = Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        }
        else {
            requestPermissions()
        }
    }
    private fun isLocationEnabled() : Boolean {
        val locationManager: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled((LocationManager.GPS_PROVIDER) ) ||
                 locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }
    private fun checkPermissions() : Boolean {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
            PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
            PackageManager.PERMISSION_GRANTED) {
            return true
        }
        return false
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION), permissionId)
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == permissionId) {
            if((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                getLocation()
            }
        }
    }

    private fun openMap() {
        val uri = Uri.parse("geo:$latitude, $longitude")
        val mapIntent = Intent(Intent.ACTION_VIEW, uri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}