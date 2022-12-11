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
                        //nothing
                    }
                });
                alerta.setNegativeButton("Proceder", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        myText = personas.getText().toString();
                        int nP = 0;
                        if(!myText.isEmpty()) {
                            nP = Integer.parseInt(myText);
                        }

                        System.out.println(myText);

                        String actMensaje = "";
                        if(nP>= 1 && nP <=5){
                            Intent intent = new Intent(WelcomeActivity.this, SelectDestinyActivity.class);
                            startActivity(intent);
                        }else if (nP>= 6 && nP <=20){
                            numPersonas(nP);
                        }else {
                            actMensaje = validarValoresInvalidosCantidadParsonas(myText);
                            //personas.setError(""+actMensaje);
                            AlertDialog.Builder mensajeError = new AlertDialog.Builder(WelcomeActivity.this);
                            mensajeError.setCancelable(false);

                            mensajeError.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //nothing
                                }
                            });

                            AlertDialog titulo2 = mensajeError.create();
                            titulo2.setMessage(actMensaje);
                            titulo2.show();
                            Button posBuuton = titulo2.getButton(DialogInterface.BUTTON_POSITIVE);
                            posBuuton.setBackgroundColor(Color.rgb(8,156,26));
                            posBuuton.setTextColor(Color.WHITE);

                        }
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

        public void numPersonas(int nP){

            int nV;

            AlertDialog.Builder alerta = new AlertDialog.Builder(WelcomeActivity.this);
            alerta.setCancelable(false);

            alerta.setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //nothing
                }
            });
            alerta.setNegativeButton("Proceder", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = new Intent(WelcomeActivity.this, SelectDestinyActivity.class);
                    startActivity(intent);
                }
            });
            nV=numVehiculos(nP);
            AlertDialog titulo = alerta.create();
            titulo.setMessage("La capacidad de pasajeros exede la capacidad de 5, desea solicitar " +nV+ " Automoviles ?");
            titulo.show();
            Button negBuuton = titulo.getButton(DialogInterface.BUTTON_NEGATIVE);
            negBuuton.setBackgroundColor(Color.rgb(8,156,26));
            negBuuton.setTextColor(Color.WHITE);

            Button posBuuton = titulo.getButton(DialogInterface.BUTTON_POSITIVE);
            posBuuton.setBackgroundColor(Color.rgb(8,156,26));
            posBuuton.setTextColor(Color.WHITE);
        }

        public int numVehiculos(int n){
            int res=0;
            if( n>5 && n<=10){
                res = 2;
            }
            if(n>10 && n<=15){
                res = 3;
            }
            if(n>15 && n<=20){
                res = 4;
            }
            return res;
        }
    public String validarValoresInvalidosCantidadParsonas (String cantParsonas){
        String mensajeError = "";
        int numPersonas = 0;
        if(cantParsonas.isEmpty()){
            mensajeError = "Cantidad de pasajeros inválido! El rango de pasajeros permitidos entre 1 y 20";
        }else{
            numPersonas = Integer.parseInt(cantParsonas);
            if(numPersonas < 1 || numPersonas > 20 ){
                mensajeError = "Cantidad de pasajeros inválido! El rango de pasajeros permitidos entre 1 y 20";
            }
        }
        System.out.println(mensajeError);
        return mensajeError;
    }


}