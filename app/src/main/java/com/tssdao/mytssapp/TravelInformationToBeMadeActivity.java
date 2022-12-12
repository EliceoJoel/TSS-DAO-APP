package com.tssdao.mytssapp;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.tssdao.mytssapp.databinding.ActivityTravelInformationToBeMadeBinding;

public class TravelInformationToBeMadeActivity extends AppCompatActivity {

    private ActivityTravelInformationToBeMadeBinding binding;
    private TextView numPassenger;
    private TextView carComeFrom;
    private TextView costoDelViaje;
    private TextView tiempoLlegada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTravelInformationToBeMadeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_travel_information_to_be_made);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        costoDelViaje = findViewById(R.id.costoViaje);
        costoDelViaje.setText(getIntent().getStringExtra(SelectDestinyActivity.COSTO_DEL_VIAJE));

        tiempoLlegada = findViewById(R.id.tiempo_de_llegada);
        tiempoLlegada.setText(getIntent().getStringExtra(TravelInformationActivity.tiempoLlegada));

        numPassenger = findViewById(R.id.num_passenger);
        numPassenger.setText(Integer.toString(getIntent().getIntExtra(WelcomeActivity.PASSENGER_NUM_PREFIX, 1)));

        carComeFrom = findViewById(R.id.car_come_from);
        carComeFrom.setText(getIntent().getStringExtra(TravelInformationActivity.CAR_COME_FROM_PREFIX));
    }
}