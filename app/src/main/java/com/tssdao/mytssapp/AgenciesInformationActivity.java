package com.tssdao.mytssapp;

import static android.app.PendingIntent.getActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class AgenciesInformationActivity extends FragmentActivity implements OnMapReadyCallback{
    private GoogleMap mMap;
    //agencia 1 Avenida Ayacucho
    LatLng agencia1 = new LatLng(-17.399504, -66.157771);
    //agencia 2 Calle Hamiraya
    LatLng agencia2 = new LatLng(-17.386864, -66.162262);
    //agencia 3 Avenida Beremeritos
    LatLng agencia3 = new LatLng(-17.398017, -66.168576);
    //agencia 4 Avenida Jose Ballivian
    LatLng agencia4 = new LatLng(-17.383069, -66.164982);
    //Creamos un array list para añadir todas las agencias
    public ArrayList<LatLng> agencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //FusedLocationProviderClient fusedLocationClient;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agencies_information);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getLocalizacion();

        //Inicializamos
        agencies = new ArrayList<>();


        //Agregamos nuestras agencias
        agencies.add(agencia1);
        agencies.add(agencia2);
        agencies.add(agencia3);
        agencies.add(agencia4);
    }

    private void getLocalizacion() {
        int permiso = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if(permiso == PackageManager.PERMISSION_DENIED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)){
            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            return;
        }

        mMap.getUiSettings().setMyLocationButtonEnabled(false);

        for(int i = 0; i < agencies.size(); i++){
            if(i == 0) {
                mMap.addMarker(new MarkerOptions().position(agencies.get(i)).title("Agencia #1")
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_iconagencies_foreground)));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(agencies.get(i), 14));
            }else if(i == 1){
                mMap.addMarker(new MarkerOptions().position(agencies.get(i)).title("Agencia #2")
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_iconagencies_foreground)));
            }else if(i == 2){
                mMap.addMarker(new MarkerOptions().position(agencies.get(i)).title("Agencia #3")
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_iconagencies_foreground)));
            }else if(i == 3){
                mMap.addMarker(new MarkerOptions().position(agencies.get(i)).title("Agencia #4")
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_iconagencies_foreground)));
            }
            mMap.animateCamera(CameraUpdateFactory.zoomTo(14.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(agencies.get(i)));
        }

        int permiso = ContextCompat.checkSelfPermission(AgenciesInformationActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION);
    }

    public ArrayList<LatLng> getAgencies() {
        return agencies;
    }
}
