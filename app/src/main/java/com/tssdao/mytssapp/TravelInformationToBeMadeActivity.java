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

        numPassenger = findViewById(R.id.num_passenger);
        numPassenger.setText(getIntent().getIntExtra(WelcomeActivity.PASSENGER_NUM_PREFIX, 1));
    }

}