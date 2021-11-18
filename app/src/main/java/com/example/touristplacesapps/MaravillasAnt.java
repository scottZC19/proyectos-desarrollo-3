package com.example.touristplacesapps;

import androidx.annotation.NonNull;
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

public class MaravillasAnt extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker MM1, MM2, MM3, MM4, MM5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maravillas_ant);
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
        LatLng Artemisa = new LatLng(37.94970917236006, 27.363890251037027);
        MM1 = googleMap.addMarker(new MarkerOptions().position(Artemisa).title("El Templo de Artemisa").
                snippet("Fue construido en honor a la diosa del mismo nombre").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.temploartemisa)));

        LatLng Halicarnaso = new LatLng(37.03811004757845, 27.424094940205574);
        MM2 = googleMap.addMarker(new MarkerOptions().position(Halicarnaso).title("El Mausoleo de Halicarnaso").
                snippet("Era la tumba del rey Mausolo.").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.mausoleo)));

        LatLng Guiza = new LatLng(29.979425083884134, 31.134291625680223);
        MM3 = googleMap.addMarker(new MarkerOptions().position(Guiza).title("La Gran Pirámide de Guiza").
                snippet("Se ubica en Egipto y es la pirámide más antigua.").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.piramide)));

        LatLng Zeus = new LatLng(37.698335919419335, 21.63865148508348);
        MM4 = googleMap.addMarker(new MarkerOptions().position(Zeus).title("La estatua de Zeus").
                snippet("Fue edificada en Olimpia en honor al padre de los dioses y los hombres").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.zeus)));

        LatLng Babilonia = new LatLng(32.967221153693934, 44.5997529678561);
        MM5 = googleMap.addMarker(new MarkerOptions().position(Babilonia).title("Los jardines colgantes de Babilonia").
                snippet("Consistían en una serie de terrazas").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.babilonia)));

        // Zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Artemisa,1));
        googleMap.setOnMarkerClickListener((this));
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        if (marker.equals(MM1)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , " + lng, Toast.LENGTH_SHORT).show();
        } else if (marker.equals(MM2)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , " + lng, Toast.LENGTH_SHORT).show();
        } else if (marker.equals(MM3)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , " + lng, Toast.LENGTH_SHORT).show();
        } else if (marker.equals(MM4)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , " + lng, Toast.LENGTH_SHORT).show();
        } else if (marker.equals(MM5)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , " + lng, Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}