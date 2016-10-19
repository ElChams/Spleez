package com.slpeez.spleez.Maps;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.slpeez.spleez.Activity.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


    public final class Constants {
        public static final int SUCCESS_RESULT = 0;
        public static final int FAILURE_RESULT = 1;
        public static final String PACKAGE_NAME =
                "com.google.android.gms.location.sample.locationaddress";
        public static final String RECEIVER = PACKAGE_NAME + ".RECEIVER";
        public static final String RESULT_DATA_KEY = PACKAGE_NAME +
                ".RESULT_DATA_KEY";
        public static final String LOCATION_DATA_EXTRA = PACKAGE_NAME +
                ".LOCATION_DATA_EXTRA";
    }

    protected void onHandleIntent(Intent intent) {
        String errorMessage = "";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        // Get the location passed to this service through an extra.
        Location location = intent.getParcelableExtra(
                Constants.LOCATION_DATA_EXTRA);

        List<Address> addresses = null;

        try {
            addresses = geocoder.getFromLocation(
                    location.getLatitude(),
                    location.getLongitude(),
                    // In this sample, get just a single address.
                    1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}