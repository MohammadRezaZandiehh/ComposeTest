package com.example.composetest

import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.composetest.databinding.ActivityMapBinding
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration.getInstance
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

class MapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapBinding

    private lateinit var map: MapView
    private lateinit var mapController: IMapController
    private lateinit var myLocationOverlay: MyLocationNewOverlay


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        map = binding.map
        getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))
        binding.map.setTileSource(TileSourceFactory.MAPNIK)

        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {

                val ctx = LocalContext.current
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxSize(),
                    verticalArrangement = Bottom,
                    horizontalAlignment = End
                ) {
                    FloatingActionButton(
                        onClick = {
                            if (!getOSMPermission()) {
                                Toast.makeText(
                                    this@MapActivity,
                                    "Permission was not allowed",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            getOSMPermission()
                            getCurrentLocation()
                        }) {
                        Text(text = "Click")
                    }
                }
            }
        }
    }


    // on below line we are creating a variable
    // for dexter and initializing it.
    private fun dexterPermission(context: Context): Boolean {
        var isPermissionGranted = false
        val dexter = Dexter.withContext(context)
            .withPermissions(

                // on below line we are specifying the permissions
                // which we have to request from our user.
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ).
                // on below line we are adding listener for permissions.
            withListener(object : MultiplePermissionsListener {

                // inside this on below line we are calling
                // a method on permission check to check the permissions.
                override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                    // on below line we are checking the status of permissions.
                    report.let {

                        // on below line we are checking if all the permissions are granted.
                        if (report!!.areAllPermissionsGranted()) {
                            // if all the permissions are granted we are displaying
                            // a simple toast message.
                            isPermissionGranted = true
                            Toast.makeText(context, "Permissions Granted..", Toast.LENGTH_SHORT)
                                .show()

                        } else {

                            // if the permissions are not accepted we are displaying
                            // a toast message as permissions denied on below line.
                            isPermissionGranted = false
                            Toast.makeText(context, "Permissions Denied..", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }

                // on below line we are calling on permission
                // rational should be shown method.
                override fun onPermissionRationaleShouldBeShown(
                    p0: MutableList<PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    // in this method we are calling continue
                    // permission request until permissions are not granted.
                    token?.continuePermissionRequest()
                }

            }).withErrorListener {

                // on below line method will be called when dexter
                // throws any error while requesting permissions.
                Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
            }
        dexter.check()

        return isPermissionGranted
    }

    private fun getOSMPermission(): Boolean {
        var isPermissionGranted2 = false

        // Request Location permission
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION

            ) == PERMISSION_GRANTED
        ) {
            isPermissionGranted2 = true
            Toast.makeText(
                this@MapActivity,
                "Location Permission GRANTED",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            isPermissionGranted2 = false
            Toast.makeText(
                this@MapActivity,
                "Location Permission DENIED",
                Toast.LENGTH_SHORT
            ).show()

            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                1
            )
        }
        return isPermissionGranted2
    }


    private fun getCurrentLocation() {
        // Set tile source + display settings
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMultiTouchControls(true)
        map.zoomController.setVisibility(CustomZoomButtonsController.Visibility.NEVER)

        // Create MapController and set starting location
        mapController = map.controller

        // Create location overlay
        myLocationOverlay = MyLocationNewOverlay(GpsMyLocationProvider(this), map)
        myLocationOverlay.enableMyLocation()
        myLocationOverlay.enableFollowLocation()
        myLocationOverlay.isDrawAccuracyEnabled = true
        myLocationOverlay.runOnFirstFix {
            runOnUiThread {
                mapController.animateTo(myLocationOverlay.myLocation)
                mapController.setZoom(18.0)
                Toast.makeText(this, "${myLocationOverlay.myLocation}", Toast.LENGTH_SHORT).show()
                Log.i("mapBoxLog", "${myLocationOverlay.myLocation}")
            }
        }
        map.overlays.add(myLocationOverlay)

        // Set user agent
//        getInstance().userAgentValue = "RossMaps"
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }
}