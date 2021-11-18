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

public class MaravillasModer extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker MA1, MA2, MA3, MA4, MA5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maravillas_moder);
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
        LatLng Roma = new LatLng(41.8903858889295, 12.49220944033741);
        MA1 = googleMap.addMarker(new MarkerOptions().position(Roma).title("El Coliseo de Roma").
                snippet("Uno de los tesoros que el Imperio romano.").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.coliseo)));

        LatLng Cristo = new LatLng(-22.95168875714212, -43.210497931169535);
        MA2 = googleMap.addMarker(new MarkerOptions().position(Cristo).title("Estatua Cristo Redentor").
                snippet("Jesús acoge con los brazos abiertos la ciudad brasileña").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.cristo)));

        LatLng Muralla = new LatLng(40.43206057283605, 116.57042452339813);
        MA3 = googleMap.addMarker(new MarkerOptions().position(Muralla).title("La Gran Muralla China").
                snippet("Antigua fortaleza que sirvió como defensa.").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.murallachina)));

        LatLng Mahal = new LatLng(27.175402484876606, 78.04216365545696);
        MA4 = googleMap.addMarker(new MarkerOptions().position(Mahal).title("Taj Mahal").
                snippet("Construido a mediados del siglo XVII por el emperador Shah Jahan").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.tajmahal)));

        LatLng Petra = new LatLng(30.323126801606357, 35.48043546699005);
        MA5 = googleMap.addMarker(new MarkerOptions().position(Petra).title("Petra").
                snippet("La capital del antiguo reino nabateo está esculpida sobre la roca.").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.petra)));

        // Zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Roma,7));
        googleMap.setOnMarkerClickListener((this));
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        if (marker.equals(MA1)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , " + lng, Toast.LENGTH_SHORT).show();
        } else if (marker.equals(MA2)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , " + lng, Toast.LENGTH_SHORT).show();
        } else if (marker.equals(MA3)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , " + lng, Toast.LENGTH_SHORT).show();
        } else if (marker.equals(MA4)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , " + lng, Toast.LENGTH_SHORT).show();
        } else if (marker.equals(MA5)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , " + lng, Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}