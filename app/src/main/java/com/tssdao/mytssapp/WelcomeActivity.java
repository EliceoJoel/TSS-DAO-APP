package com.tssdao.mytssapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    Button btnSolicitarAuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide title bar for welcome layout view
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        //Sets activity_main.xml layout to the app view
        setContentView(R.layout.activity_welcome);

        //Getting button to pass to next view
        btnSolicitarAuto = findViewById(R.id.solauto);
        btnSolicitarAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, SelectDestinyActivity.class);
                startActivity(intent);
            }
        });
    }
}