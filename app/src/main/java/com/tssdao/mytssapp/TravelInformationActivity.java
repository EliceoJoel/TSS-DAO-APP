package com.tssdao.mytssapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    public static final String PRECIO_TOTAL = "precio_total";
    public static final String TIEMPO_LLEGADA = "tiempo_llegada";


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
                intent.putExtra(MyTravel.PREFIX, myTravelInfo);
                startActivity(intent);
            }
        });
    }
}