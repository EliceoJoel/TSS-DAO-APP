package com.tssdao.mytssapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.util.HashMap;
import java.util.Map;


public class WelcomeActivity extends AppCompatActivity {

    private Button dialogoBtn;
    private String myText;
    private int numeroDeAutos;
    FirebaseFirestore store;



    public static final String CAR_NUM_PREFIX = "car_number";
    public static final String PASSENGER_NUM_PREFIX = "passenger_number";
   // private Web3j
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        store = FirebaseFirestore.getInstance();
        //connectToFireBase();
        //Hide title bar for welcome layout view
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        //Sets activity_main.xml layout to the app view
        setContentView(R.layout.activity_welcome);
        dialogoBtn = (Button) findViewById(R.id.solauto);
        dialogoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectToNode();

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
                            intent.putExtra(PASSENGER_NUM_PREFIX, nP);
                            intent.putExtra(CAR_NUM_PREFIX, 1);
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
        //Permisos para almacenar
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                        PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,},
                    1000);
        }


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
                    intent.putExtra(PASSENGER_NUM_PREFIX, nP);
                    intent.putExtra(CAR_NUM_PREFIX, numVehiculos(nP)); //
                    startActivity(intent);
                }
            });
            nV=numVehiculos(nP);
            numeroDeAutos = nV;
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

    public void connectToNode(){
        // Test 1 for smart contract
        /*Web3j web3j = Web3j.build(
                new HttpService("https://mainnet.infura.io/v3/fe8ba8e44c2846f7ada61e1c463b0eaf")
        );
        Credentials credentials = Credentials.create("fe8ba8e44c2846f7ada61e1c463b0eaf");
        RemoteCall test = smart.Test_sol_SimpleStorage.deploy(web3j, credentials, new DefaultGasProvider(), "test");
        test.sendAsync();
        web3j.shutdown();
        */

        // Test 2 for connection to node
        Web3j web3j = Web3j.build(new HttpService("https://goerli.infura.io/v3/fe8ba8e44c2846f7ada61e1c463b0eaf"));
        try {
            Web3ClientVersion clientVersion = web3j.web3ClientVersion()
                    .sendAsync().get();
            if (!clientVersion.hasError()) {
                Toast.makeText(this, "Connected", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, clientVersion.getError().getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }


    public void connectToFireBase(){
        Map<String,Object> docente = new HashMap<>();
        /*docente.put("FirstName", "Henry");
        docente.put("LastName", "Villaroel");
        docente.put("Labor Position", "Director de Carrera");*/

        /*store.collection("docentes").add(docente).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "FAILED", Toast.LENGTH_LONG).show();
            }
        });*/
        docente.put("disponibilidad", "4");
        docente.put("direccion", "av. aroma");
        docente.put("presupuesto", "3000");

        store.collection("agencias").document("Agencia1")
                .set(docente)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });



    }


}