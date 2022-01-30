package com.maksapp.moviesearchapp.View

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.motion.widget.Debug.getLocation
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.maksapp.moviesearchapp.R
import java.io.IOException

class FragmentForLocation: Fragment() {




    companion object{
        fun newInstance() = FragmentForLocation()


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.location, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestPermission()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private val permissionResult =

            registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
                when {
                    result -> showLocation()
                    !shouldShowRequestPermissionRationale(
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) -> {
                        context?.let {
                            AlertDialog.Builder(it)
                                .setTitle("Доступ нннада")
                                .setMessage("ощень хочеься")
                                .setPositiveButton("на доступ") { _, _ -> requestPermission() }
                                .setNegativeButton("не не не") { dialog, _ -> dialog.dismiss() }
                                .create()
                                .show()
                        }

                    }
                    else -> requestPermission()
                }
            }


    @SuppressLint("MissingPermission")
    private fun showLocation() {
        context?.let {
            val locationManager = requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                val  providerGps = locationManager.getProvider(LocationManager.GPS_PROVIDER)

                providerGps?.let {
                    locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        60_000L,
                        100f
                    ) { location ->
                        AlertDialog.Builder(requireActivity())
                            .setTitle("I am")
                            .setMessage("${location.latitude}${location.longitude}")
                            .show()
                    }

                }
            }else{
                val location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                location?.let {
                    AlertDialog.Builder(requireActivity())
                        .setTitle("I am")
                        .setMessage("${location.latitude}${location.longitude}")
                        .show()
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun requestPermission() {
        permissionResult.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }


}