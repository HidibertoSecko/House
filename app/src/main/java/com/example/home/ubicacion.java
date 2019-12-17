package com.example.home;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class ubicacion extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);
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
        LatLng potosi = new LatLng(-19.5582635, -65.7638169);
        mMap.addMarker(new MarkerOptions().position(potosi).title("Zona Lecherias").draggable(true));
        CameraPosition camarePosicion = new CameraPosition.Builder()
                .target(potosi)
                .zoom(16)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Toast.makeText(ubicacion.this, "Coordenadas \n" +
                        "Lat:" + latLng.latitude + "\n"  +
                        "Log:" + latLng.longitude ,
                        Toast.LENGTH_LONG).show();
            }
        });

        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {

            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(ubicacion.this, marker.getTitle(), Toast.LENGTH_LONG).show();
                return false;
            }
        });

        LatLng potosiz = new LatLng(-19.5582335, -65.7646169);
        mMap.addMarker(new MarkerOptions().position(potosiz).title("Zona Lecherias").draggable(true));
        CameraPosition camarPosicion = new CameraPosition.Builder()
                .target(potosiz)
                .zoom(16)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Toast.makeText(ubicacion.this, "Coordenadas \n" +
                                "Lat:" + latLng.latitude + "\n"  +
                                "Log:" + latLng.longitude ,
                        Toast.LENGTH_LONG).show();
            }
        });

        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {

            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(ubicacion.this, marker.getTitle(), Toast.LENGTH_LONG).show();
                return false;
            }
        });

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camarePosicion));

        // mMap.moveCamera(CameraUpdateFactory.newLatLng(potosi));

    }

    public void poligono(View view) {
        CameraUpdate camUpd2 = CameraUpdateFactory.newLatLngZoom(new LatLng(
                -19.5584535, -65.7646239), 7F);
        mMap.animateCamera(camUpd2);
        PolygonOptions opcionesPoligono = new PolygonOptions()
                .add(new LatLng(-19.5524335, -65.7647969))
                .add(new LatLng(-19.5583435, -65.7643469))
                .add(new LatLng(-19.5583535, -65.7646769))
                .add(new LatLng(-19.5587835, -65.7646569))
                .add(new LatLng(-19.5562335, -65.7649169));
        mMap.clear();
        Polygon poligono = mMap.addPolygon(opcionesPoligono);
        poligono.setFillColor(Color.BLUE); // Relleno del polígono
        poligono.setStrokeColor(Color.RED); // Bordes del polígono
    }
}
