package com.example.touristplacesapps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class LugaresCusco extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker markerLC1, markerLC2, markerLC3, markerLC4, markerLC5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares_cusco);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng Sacsayhuaman = new LatLng(-13.50975939690610, -71.98166700738146);
        markerLC1 = googleMap.addMarker(new MarkerOptions().position(Sacsayhuaman).title("Sacsayhuaman").
                snippet("Destacan sus chincanas, puertas, murallas así como suchunas.").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.sacsayhuaman)));

        LatLng Pisac = new LatLng(-13.414595326226078, -71.84809870805238);
        markerLC2 = googleMap.addMarker(new MarkerOptions().position(Pisac).title("Pisac").
                snippet("Sitio arqueológico con magníficas estructuras como el Templo del Sol.").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.choquequi)));

        LatLng Ollantaytambo = new LatLng(-13.23146229639221, -72.26810743030734);
        markerLC3 = googleMap.addMarker(new MarkerOptions().position(Ollantaytambo).title("Ollantaytambo").
                snippet("Recinto sagrado que funcionó de fortaleza durante la invasión española.").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.ollantay)));

        LatLng MColores = new LatLng(-13.864011675517599, -71.30328665773081);
        markerLC4 = googleMap.addMarker(new MarkerOptions().position(MColores).title("La montaña de 7 colores").
                snippet("Se encuentra a los pies del nevado Ausangate el más alto de Cusco.").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.montana)));

        LatLng MachuPicchu = new LatLng(-13.162930810682083, -72.54493366211277);
        markerLC5 = googleMap.addMarker(new MarkerOptions().position(MachuPicchu).title("Machu Picchu").
                snippet("La ciudad inca y una de las 7 maravillas ").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.machupicchu)));

        //Zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Sacsayhuaman,7));
        googleMap.setOnMarkerClickListener((this));

    }

    @Override
    public boolean onMarkerClick(Marker marker){
        if (marker.equals(markerLC1)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , " + lng, Toast.LENGTH_SHORT).show();
        } else if (marker.equals(markerLC2)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , " + lng, Toast.LENGTH_SHORT).show();
        } else if (marker.equals(markerLC3)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , " + lng, Toast.LENGTH_SHORT).show();
        } else if (marker.equals(markerLC4)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , " + lng, Toast.LENGTH_SHORT).show();
        } else if (marker.equals(markerLC5)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , " + lng, Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}