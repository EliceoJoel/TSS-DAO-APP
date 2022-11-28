package com.tssdao.mytssapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {

    private Button dialogoBtn;
    private String myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide title bar for welcome layout view
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        //Sets activity_main.xml layout to the app view
        setContentView(R.layout.activity_welcome);
        dialogoBtn = (Button) findViewById(R.id.solauto);
        dialogoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alerta = new AlertDialog.Builder(WelcomeActivity.this);


                alerta.setCancelable(false);
                final EditText personas = new EditText(WelcomeActivity.this);
                personas.setInputType(InputType.TYPE_CLASS_NUMBER);
                alerta.setView(personas);
                alerta.setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                alerta.setNegativeButton("Proceder", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        myText = personas.getText().toString();
                        Intent intent = new Intent(WelcomeActivity.this, SelectDestinyActivity.class);
                        startActivity(intent);
                    }
                });
                AlertDialog titulo = alerta.create();
                titulo.setTitle("Para cuantas personas necesita el servicio?");
                titulo.show();
                Button negBuuton = titulo.getButton(DialogInterface.BUTTON_NEGATIVE);
                negBuuton.setBackgroundColor(Color.rgb(8,156,26));
                negBuuton.setTextColor(Color.WHITE);

                Button posBuuton = titulo.getButton(DialogInterface.BUTTON_POSITIVE);
                posBuuton.setBackgroundColor(Color.rgb(8,156,26));
                posBuuton.setTextColor(Color.WHITE);

            }
        });


    }
}