package com.tssdao.mytssapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TravelInformationActivity extends AppCompatActivity {

    private Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_information);

        //Getting button to pass to next view
        btnPay = findViewById(R.id.btn_pay);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TravelInformationActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });
    }
}sdfsdfsddssdf