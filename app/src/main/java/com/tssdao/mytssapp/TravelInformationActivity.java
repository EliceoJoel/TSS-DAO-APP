package com.tssdao.mytssapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TravelInformationActivity extends AppCompatActivity {

    private MyTravel myTravelInfo;
    private Button btnPay;
    private TextView txtArriveTime;
    private TextView txtToDestinyTime;
    private TextView txtTotalPrice;

    public static final String CAR_COME_FROM_PREFIX = "car_come_from";
    public static final String tiempoLlegada = "tiempoLlegada";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_information);

        myTravelInfo = (MyTravel) getIntent().getSerializableExtra(MyTravel.PREFIX);
        //Set information to layout
        txtArriveTime = findViewById(R.id.arrive_time);
        txtArriveTime.setText(myTravelInfo.getArriveTimeEstimated());

        txtToDestinyTime = findViewById(R.id.to_destiny_time);
        txtToDestinyTime.setText(myTravelInfo.getToDestinyTimeEstimated());

        txtTotalPrice = findViewById(R.id.total_price);
        txtTotalPrice.setText(String.valueOf(myTravelInfo.getTotalPrice()) + " Bs.");

        //Getting button to pass to next view
        btnPay = findViewById(R.id.btn_pay);
        btnPay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TravelInformationActivity.this, CheckoutActivity.class);
                intent.putExtra(WelcomeActivity.PASSENGER_NUM_PREFIX, getIntent().getIntExtra(WelcomeActivity.PASSENGER_NUM_PREFIX, 1));
                intent.putExtra(CAR_COME_FROM_PREFIX, myTravelInfo.getAgenciesFromMyCarCome());
                intent.putExtra(tiempoLlegada, myTravelInfo.getToDestinyTimeEstimated());
                intent.putExtra(SelectDestinyActivity.COSTO_DEL_VIAJE, getIntent().getStringExtra(SelectDestinyActivity.COSTO_DEL_VIAJE));
                startActivity(intent);
            }
        });
    }
}