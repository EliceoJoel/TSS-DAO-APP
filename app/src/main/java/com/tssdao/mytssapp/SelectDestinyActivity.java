package com.tssdao.mytssapp;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tssdao.mytssapp.databinding.ActivitySelectDestinyBinding;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class SelectDestinyActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivitySelectDestinyBinding binding;
    private Button btnConfirmDestinty;
    private List<Double> distancesBetweenAgencyAndCurrentLocation;
    private int carQuantity = 2; // este valor vendra del layaout anterior
    private String arriveTimeEstimated = "15 minutos"; // Valor fake - esto es algo que Samuel debe calcular con google maps
    private String toDestinyTimeEstimated = "30 minutos"; // Valor fake - esto es algo que Samuel debe calcular con google maps

    //The maximum distance between the client and agencies in kilometers to take into account before send cars to the client
    public static double MAX_DISTANCE_BETWEEN_AGENCY_AND_CURRENT_LOCATION = 5.0;
    //Price per kilometer in bs.
    public static double PRICE_PER_KILOMETER =  2.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySelectDestinyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Initialize list of distances between agencies and current location
        //Esto solo es un ejemplo de las posibles distancias entre el usuario y las agencias al momento de solicitar el servicio
        //Para que pase al otro activity reducir alguna distancia entre 0.0 y 5.0
        distancesBetweenAgencyAndCurrentLocation = Arrays.asList(3.3, 7.3, 6.3, 5.3);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Getting button to pass to next view
        btnConfirmDestinty = findViewById(R.id.btn_confirm_destiny);
        btnConfirmDestinty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyTravel myTravel = new MyTravel(arriveTimeEstimated, toDestinyTimeEstimated,  getEstimatedPrice());
                //Calcular distancias entre ubicacion actual y agencias aqui
                //anadir las distancias al array aqui
                if(!isOutOfRange()) {
                    Intent intent = new Intent(SelectDestinyActivity.this, TravelInformationActivity.class);
                    intent.putExtra(MyTravel.PREFIX, myTravel);
                    startActivity(intent);
                } else {
                    showOutOfRangeDialog();
                }
            }
        });
    }

    private boolean isOutOfRange() {
        double minDistance = Collections.min(distancesBetweenAgencyAndCurrentLocation);
        return minDistance <= MAX_DISTANCE_BETWEEN_AGENCY_AND_CURRENT_LOCATION ? false : true;
    }

    private void showOutOfRangeDialog() {
        SimpleAlertDialog alertDialog = new SimpleAlertDialog(
                "Fuera de rango",
                "La distancia desde donde se solicita el servicio esta muy alejada de nuestras agencias, mantente dentro de los 5km",
                "OK");
        alertDialog.show(getSupportFragmentManager(), "Alert dialog");
    }

    private double getEstimatedPrice() {
        return PRICE_PER_KILOMETER * Collections.min(distancesBetweenAgencyAndCurrentLocation) * carQuantity;
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

        Agencias(googleMap);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                mMap.clear();
                mMap.addMarker(new MarkerOptions().position(point));
            }
        });
    }

    public void Agencias(GoogleMap googleMap){

        mMap = googleMap;
        LatLng agencia1 = new LatLng(-17.399504, -66.157771);
        mMap.addMarker(new MarkerOptions().position(agencia1).title("Agencia #1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(agencia1, 15));

        LatLng agencia2 = new LatLng(-17.386864, -66.162262);
        mMap.addMarker(new MarkerOptions().position(agencia2).title("Agencia #2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng agencia3 = new LatLng(-17.397961, -66.168682);
        mMap.addMarker(new MarkerOptions().position(agencia3).title("Agencia #3").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng agencia4 = new LatLng(-17.383069, -66.164982);
        mMap.addMarker(new MarkerOptions().position(agencia4).title("Agencia #4").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

    }
}