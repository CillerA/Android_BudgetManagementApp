package com.example.ciller.pm;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.style.TtsSpan;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Circle myCircle;

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

        LatLng BRD_Dorobanti = new LatLng(44.456159, 26.096627);
        mMap.addMarker(new MarkerOptions().position(BRD_Dorobanti).title("BRD Dorobanti"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BRD_Dorobanti, 13));

        LatLng BCR_Crangasi = new LatLng(44.454081, 26.053169);
        mMap.addMarker(new MarkerOptions().position(BCR_Crangasi).title("BCR Crangasi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BCR_Crangasi, 13));

        LatLng Ciller_Home = new LatLng(44.475708, 26.068680);
        mMap.addMarker(new MarkerOptions().position(Ciller_Home).title("Ciller's House"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Ciller_Home, 13));

        LatLng Rent_Money = new LatLng(44.444437, 26.136483);
        mMap.addMarker(new MarkerOptions().position(Rent_Money).title("Rent money"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Rent_Money, 13));

        LatLng HomeSweetHome = new LatLng(44.430850, 25.993002 );
        mMap.addMarker(new MarkerOptions().position(HomeSweetHome).title("Home Sweet Home"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HomeSweetHome, 13));
        CircleOptions co = new CircleOptions();
        co.center(HomeSweetHome);
        co.radius(10000);
        co.fillColor(Color.rgb(250, 120, 65));
        co.strokeColor(10);
        myCircle = mMap.addCircle(co);

        LatLng Raiffeisen = new LatLng(  44.405684, 26.065268 );
        mMap.addMarker(new MarkerOptions().position(Raiffeisen).title("Raiffeisen"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Raiffeisen, 13));

        PolylineOptions po1 = new PolylineOptions();
        po1.add(HomeSweetHome);
        po1.add(BRD_Dorobanti);
        po1.color(Color.rgb(155, 24, 240));
        po1.width(10);


        PolylineOptions po2 = new PolylineOptions();
        po2.add(HomeSweetHome);
        po2.add(BCR_Crangasi);
        po2.color(Color.RED);
        po2.width(10);

        PolylineOptions po3 = new PolylineOptions();
        po3.add(HomeSweetHome);
        po3.add(Ciller_Home);
        po3.color(Color.CYAN);
        po3.width(10);

        PolylineOptions po4 = new PolylineOptions();
        po4.add(HomeSweetHome);
        po4.add(Rent_Money);
        po4.color(Color.GREEN);
        po4.width(10);

        PolylineOptions po5 = new PolylineOptions();
        po5.add(HomeSweetHome);
        po5.add(Raiffeisen);
        po5.color(Color.rgb(0, 0, 0));
        po5.width(10);

        mMap.addPolyline(po1);
        mMap.addPolyline(po2);
        mMap.addPolyline(po3);
        mMap.addPolyline(po4);
        mMap.addPolyline(po5);



    }



}

