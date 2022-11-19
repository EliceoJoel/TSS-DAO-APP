package com.tssdao.mytssapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckoutActivity extends AppCompatActivity {

    private Button btnPayAndStartTravel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //Getting button to pass to next view
        btnPayAndStartTravel = findViewById(R.id.btn_pay_and_start);
        btnPayAndStartTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckoutActivity.this, TravelInformationToBeMadeActivity.class);
                startActivity(intent);
            }
        });
    }
}