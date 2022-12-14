package com.tssdao.mytssapp;

import static android.location.LocationManager.NETWORK_PROVIDER;


import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tssdao.mytssapp.databinding.ActivitySelectDestinyBinding;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SelectDestinyActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    FusedLocationProviderClient fusedLocationProviderClient;
    private ActivitySelectDestinyBinding binding;
    private Button btnConfirmDestinty;
    private List<Double> distancesBetweenAgencyAndCurrentLocation;
    private int carQuantity; // este valor vendra del layaout anterior
    private String arriveTimeEstimated;
    private String toDestinyTimeEstimated;

    //The maximum distance between the client and agencies in kilometers to take into account before send cars to the client
    public static double MAX_DISTANCE_BETWEEN_AGENCY_AND_CURRENT_LOCATION = 5.0;
    //Price per kilometer in bs.
    public static double PRICE_PER_KILOMETER =  2.5; // Se corrigio el precio de 2 bs a 3 bs
    public LatLng ubicacionDestino;
    public LatLng myPosition;
    AgenciesInformationActivity agencias = new AgenciesInformationActivity();
    private double dist = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySelectDestinyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        carQuantity = getIntent().getIntExtra(WelcomeActivity.CAR_NUM_PREFIX, 1);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        //Initialize list of distances between agencies and current location
        distancesBetweenAgencyAndCurrentLocation = new ArrayList<>();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Getting button to pass to next view
        btnConfirmDestinty = findViewById(R.id.btn_confirm_destiny);

        btnConfirmDestinty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Utiizar las siguientes ubicaciones o otros, para verificar
                //Ubicacion real del usuario
                //myPosition = getMyPosition();
                //Ubicacion fuera de rango (como ejemplo)
                //myPosition = new LatLng(-17.430831, -66.118590);
                //Ubicacion dentro del rango (como ejemplo)
                myPosition = new LatLng(-17.394108, -66.149405);
                //Distancias desde las Agencias al Usuario;
                Distance distance = new Distance(myPosition, getUbicacionDestino());
                distancesBetweenAgencyAndCurrentLocation = distance.listDistance();
                System.out.println("Lista de distancia: " + distancesBetweenAgencyAndCurrentLocation);

                //Tiempo de arrivo de la agencia hasta usuario
                Time time = new Time(distance.distanciaMenor());
                arriveTimeEstimated = (int) time.getTime() + " minutos";

                //Distancia desde el Usuario al Destino seleccionado
                dist = distance.calDistanceUserAndSelectDestiny();
                time.setDistance(distance.calDistanceUserAndSelectDestiny());
                System.out.println("Distancia de Usuario a Destino"+ dist);
                toDestinyTimeEstimated = (int) time.getTime() + " minutos";

                MyTravel myTravel = new MyTravel(arriveTimeEstimated, toDestinyTimeEstimated, getEstimatedPrice(), getAgencyFromCome(distance.listDistance()), carQuantity, getIntent().getIntExtra(WelcomeActivity.PASSENGER_NUM_PREFIX, 1));

                if (!isOutOfRange()) {
                    Intent intent = new Intent(SelectDestinyActivity.this, TravelInformationActivity.class);
                    intent.putExtra(MyTravel.PREFIX, myTravel);
                    startActivity(intent);
                } else {
                    showOutOfRangeDialog();
                }
            }
        });
    }
    private Agencias getAgencyFromCome(List<Double> distances) {
        double minDistance = Collections.min(distancesBetweenAgencyAndCurrentLocation);
        int agencyNumber = 0;
        for(int index = 0; index < distances.size(); index++) {
            if(distances.get(index) == minDistance) {
                agencyNumber = index;
                break;
            }
        }
        Agencias agencia = null;
        switch (agencyNumber) {
            case 0:
                agencia = Agencias.AGENCIA1;
                break;
            case 1:
                agencia = Agencias.AGENCIA2;
                break;
            case 2:
                agencia = Agencias.AGENCIA3;
                break;
            case 3:
                agencia = Agencias.AGENCIA4;
                break;
            default:
                agencia = Agencias.AGENCIA1;
        }

        return agencia;
    }

    private boolean isOutOfRange() {
        double minDistance = Collections.min(distancesBetweenAgencyAndCurrentLocation);
        return minDistance <= MAX_DISTANCE_BETWEEN_AGENCY_AND_CURRENT_LOCATION ? false : true;
    }

    private void showOutOfRangeDialog() {
        SimpleAlertDialog alertDialog = new SimpleAlertDialog(
                "Fuera de rango",
                "La distancia desde donde se solicita el servicio esta muy alejada de nuestras agencias, mantente dentro de los 5 km",
                "OK");
        alertDialog.show(getSupportFragmentManager(), "Alert dialog");
    }

    private double getEstimatedPrice() {
        double costoTotal = PRICE_PER_KILOMETER * dist * carQuantity;
        System.out. println(String.valueOf(costoTotal).length());


        if (String.valueOf(costoTotal).length() > 4){
            costoTotal = Math.round(costoTotal*100.0)/100.0;
            //Math.round(n*100.0)/100.0;
        }

        return costoTotal;
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
    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);



        Agencias(googleMap);
        moveZoom(new LatLng(-17.394108, -66.149405));
        btnConfirmDestinty.setEnabled(false);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                mMap.clear();
                Agencias(googleMap);
                mMap.addMarker(new MarkerOptions().position(point));
                btnConfirmDestinty.setEnabled(true);
                moveZoom(point);
                setUbicacionDestino(point);

            }
        });

        LocationManager locationManager = (LocationManager) SelectDestinyActivity.this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                LatLng miUbicacion = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(miUbicacion).title("usuario").icon(BitmapDescriptorFactory.fromResource(R.drawable.usericonofficial)).anchor(0.0f,0.0f));
                setMyPosition(miUbicacion);
            }

            @Override
            public  void onStatusChanged(String provider, int status, Bundle extras){

            }
        };
        locationManager.requestLocationUpdates(NETWORK_PROVIDER, 0,0, locationListener);

    }

    public void Agencias(GoogleMap googleMap){

        mMap = googleMap;
        LatLng agencia1 = new LatLng(-17.399504, -66.157771);
        mMap.addMarker(new MarkerOptions().position(agencia1).title("Agencia #1").icon(BitmapDescriptorFactory.fromResource(R.drawable.cariconofficial)));

        LatLng agencia2 = new LatLng(-17.386864, -66.162262);
        mMap.addMarker(new MarkerOptions().position(agencia2).title("Agencia #2").icon(BitmapDescriptorFactory.fromResource(R.drawable.cariconofficial)));

        LatLng agencia3 = new LatLng(-17.397961, -66.168682);
        mMap.addMarker(new MarkerOptions().position(agencia3).title("Agencia #3").icon(BitmapDescriptorFactory.fromResource(R.drawable.cariconofficial)));

        LatLng agencia4 = new LatLng(-17.383069, -66.164982);
        mMap.addMarker(new MarkerOptions().position(agencia4).title("Agencia #4").icon(BitmapDescriptorFactory.fromResource(R.drawable.cariconofficial)));

    }

    private void moveZoom (LatLng point) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 15));
    }

    public LatLng getUbicacionDestino() {
        return ubicacionDestino;
    }

    public void setUbicacionDestino(LatLng ubicacionDestino) {
        this.ubicacionDestino = ubicacionDestino;
    }

    public void setMyPosition(LatLng myPosition) {
        this.myPosition = myPosition;
    }

    public LatLng getMyPosition() {
        return myPosition;
    }

}