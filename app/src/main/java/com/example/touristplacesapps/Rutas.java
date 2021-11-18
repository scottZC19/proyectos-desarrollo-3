package com.example.touristplacesapps;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Rutas extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    Boolean actualPosition = true;
    JSONObject jso;
    Double longitudOrigen, latitudOrigen;



    private Marker markerLC1, markerLC2, markerLC3, markerLC4, markerLC5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutas);
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
        /*LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {


            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        1);
            }

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        1);
            }
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {

                //2.942043!4d-75.2522789


                if (actualPosition){
                    latitudOrigen = location.getLatitude();
                    longitudOrigen = location.getLongitude();
                    actualPosition=false;

                    LatLng miPosicion = new LatLng(latitudOrigen,longitudOrigen);

                    mMap.addMarker(new MarkerOptions().position(miPosicion).title("Aqui estoy yo"));

                    CameraPosition cameraPosition = new CameraPosition.Builder()
                            .target(new LatLng(latitudOrigen,longitudOrigen))
                            .zoom(17)
                            .bearing(90)
                            .build();
                    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
            }
        });




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
    public boolean onMarkerClick(@NonNull Marker marker) {
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



//-13.52329784063645, -71.97495826791062 //ruta destino yola
//-13.539102398314943, -71.95633406512765 // mi ubicacion