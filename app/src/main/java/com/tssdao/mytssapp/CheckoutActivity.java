package com.tssdao.mytssapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class CheckoutActivity extends AppCompatActivity {

    private Button btnPayAndStartTravel;
    private EditText cardNumber;
    private EditText cardExpirationMonth;
    private EditText cardExpirationYear;
    private EditText cardCVC;
    private TextView numberError;
    private TextView monthError;
    private TextView yearError;
    private TextView cvcError;
    private int numeroAgenciaActual = 0;
    private boolean agenciaConAutosEncontrada = false;
    private String nombreDeAgenciaDeDondeVieneAuto;
    private MyTravel myTravel;
    private FirebaseFirestore db;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String TAG = "MENSAJE:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //iniciar firebase
        db = FirebaseFirestore.getInstance();

        //Getting elements from the layout
        btnPayAndStartTravel = findViewById(R.id.btn_pay_and_start);
        cardNumber = findViewById(R.id.input_card_number);
        cardExpirationMonth = findViewById(R.id.input_card_expiration_month);
        cardExpirationYear = findViewById(R.id.input_card_expiration_year);
        cardCVC = findViewById(R.id.input_card_cvc);

        numberError = findViewById(R.id.number_error);
        monthError = findViewById(R.id.month_error);
        yearError = findViewById(R.id.year_error);
        cvcError = findViewById(R.id.cvc_error);

        myTravel = (MyTravel) getIntent().getSerializableExtra(MyTravel.PREFIX);
        nombreDeAgenciaDeDondeVieneAuto = myTravel.getAgenciesFromMyCarCome().getUbicacion();

        btnPayAndStartTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearErrors();
                if(cardValidation()) {

                    enviarAuto(myTravel);
                    actualizarGananciaTotal();
                    almacenarDatosDelviajeEnDispositivo(myTravel.getTotalPrice(), myTravel.getNumberOfPassanger(), myTravel.getToDestinyTimeEstimated(), myTravel.getAgenciesFromMyCarCome().getUbicacion());

                    Intent intent = new Intent(CheckoutActivity.this, TravelInformationToBeMadeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void enviarAuto(MyTravel myTravel) {
        String nombreAgencia = myTravel.getAgenciesFromMyCarCome().getNombre();
        DocumentReference docRef = db.collection("agencias").document(nombreAgencia);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());

                        if(tieneAutosDisponibles(document.getData(), myTravel.getNumberOfCars())) {
                            DocumentReference docRef = db.collection("agencias").document(nombreAgencia);
                            Long cantidadActualDeAutosDisponibles = (Long) document.getData().get("autos_disponibles");
                            actualizarCantidadDeAutosDeAgencia(docRef, cantidadActualDeAutosDisponibles);
                            actualizarPresupuestoAgencia(nombreAgencia);
                        } else {
                            actualizarSiguienteAgenciaConAutos(myTravel.getAgenciesFromMyCarCome().getNumero());
                        }

                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    private void actualizarCantidadDeAutosDeAgencia(DocumentReference documentReference, Long cantidadActual) {
        documentReference.update("autos_disponibles", cantidadActual - myTravel.getNumberOfCars());
    }

    private void actualizarSiguienteAgenciaConAutos(int numeroAgenciaSinAutos) {
        //recorremos todas las agencias restantes para ver quien tiene autos disponibles
        numeroAgenciaActual = numeroAgenciaSinAutos == 4 ? 1 : numeroAgenciaSinAutos + 1;
        for (int index = 1; index < 4; index++) {
            String nombreAgenciaActual = getNombreAgenciaPorNumero(numeroAgenciaActual);
            DocumentReference docRef = db.collection("agencias").document(nombreAgenciaActual);
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            Log.d(TAG, "DocumentSnapshot data: " + document.getData());

                            if(tieneAutosDisponibles(document.getData(), myTravel.getNumberOfCars())) {
                                DocumentReference docRef = db.collection("agencias").document(nombreAgenciaActual);
                                Long cantidadActualDeAutosDisponibles = (Long) document.getData().get("autos_disponibles");
                                actualizarCantidadDeAutosDeAgencia(docRef, cantidadActualDeAutosDisponibles);
                                actualizarPresupuestoAgencia(nombreAgenciaActual);
                                agenciaConAutosEncontrada = true;
                            } else {
                                //si la agencia que no tiene autos es la 4, empezar a revisar la agencia 1
                                numeroAgenciaActual = (numeroAgenciaActual + 1) == 4 ? 1 : numeroAgenciaActual + 1;
                            }

                        } else {
                            Log.d(TAG, "No such document");
                        }
                    } else {
                        Log.d(TAG, "get failed with ", task.getException());
                    }
                }
            });
            if(agenciaConAutosEncontrada) {
                break; // si ya se encontro una agencia, romper el ciclo for
            }
        }
    }

    private String getNombreAgenciaPorNumero(int numero) {
        String nombre = "";
        switch (numero) {
            case 1:
                nombre = "agencia1";
                break;
            case 2:
                nombre = "agencia2";
                break;
            case 3:
                nombre = "agencia3";
                break;
            case 4:
                nombre = "agencia4";
                break;
            default:
                nombre = "";
        }
        return nombre;
    }

    private boolean tieneAutosDisponibles(Map<String, Object> agencia, int cantidaDeAutosNecesarios) {
        Long autosDisponiblesEnAgencia = (Long) agencia.get("autos_disponibles");
        if( autosDisponiblesEnAgencia < cantidaDeAutosNecesarios) {
            return false;
        }
        return true;
    }

    private  void clearErrors() {
        numberError.setVisibility(View.GONE);
        monthError.setVisibility(View.GONE);
        yearError.setVisibility(View.GONE);
        cvcError.setVisibility(View.GONE);
    }

    private boolean cardValidation() {
        boolean result = true;
        if(isStringInteger(cardNumber.getText().toString(), 10)) {
            if(cardNumber.getText().length() != 16) {
                numberError.setVisibility(View.VISIBLE);
                result = false;
            }
        } else {
            numberError.setVisibility(View.VISIBLE);
            result = false;
        }

         if(isStringInteger(cardExpirationMonth.getText().toString(), 10)) {
             if(Integer.parseInt(cardExpirationMonth.getText().toString()) < 1 || Integer.parseInt(cardExpirationMonth.getText().toString()) > 12) {
                 monthError.setVisibility(View.VISIBLE);
                 result = false;
             }
         } else {
             monthError.setVisibility(View.VISIBLE);
             result = false;
         }

         if(isStringInteger(cardExpirationYear.getText().toString(), 10)) {
             if(cardExpirationYear.getText().length() != 2) {
                 yearError.setVisibility(View.VISIBLE);
                 result = false;
             }
         } else {
             yearError.setVisibility(View.VISIBLE);
             result = false;
         }

         if(isStringInteger(cardCVC.getText().toString(), 10)) {
             if(cardCVC.getText().length() != 3) {
                 cvcError.setVisibility(View.VISIBLE);
                 result = false;
             }
         } else {
             cvcError.setVisibility(View.VISIBLE);
             result = false;
         }

        return result;
    }

    public boolean isStringInteger(String stringToCheck, int radix) {
        if(stringToCheck.isEmpty()) return false;           //Check if the string is empty
        for(int i = 0; i < stringToCheck.length(); i++) {
            if(i == 0 && stringToCheck.charAt(i) == '-') {     //Check for negative Integers
                if(stringToCheck.length() == 1) return false;
                else continue;
            }
            if(Character.digit(stringToCheck.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    private void almacenarDatosDelviajeEnDispositivo(double costoViaje, int numeroPasajeros, String tiempoLlegada, String agencias) {
        sharedPreferences = this.getSharedPreferences("mylocal", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putString("D_costo_viaje",  Double.toString(costoViaje) + " Bs.");
        editor.putString("D_numero_pasajeros", Integer.toString(numeroPasajeros));
        editor.putString("D_tiempo_llegada", tiempoLlegada);
        editor.putString("D_agencias", agencias);
        editor.putString("mensaje_viaje", "Ya estamos en camino, esperanos...");
        editor.putString("btn_text", "Confirmar llegada");
        editor.apply();
    }

    private void actualizarGananciaTotal() {
        DocumentReference docRef = db.collection("informacion_empresa").document("ganancia");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        Object totalActual = document.getData().get("total");
                        double totalAAgregar = myTravel.getTotalPrice() * 0.3;
                        if(totalActual instanceof Long) {
                            docRef.update("total", (Long)totalActual + totalAAgregar);
                        } else if (totalActual instanceof Double) {
                            docRef.update("total", (Double)totalActual + totalAAgregar);
                        }
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    private void actualizarPresupuestoAgencia(String nombreAgencia) {
        DocumentReference docRef = db.collection("agencias").document(nombreAgencia);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        Object presupuestoAgenciaActual = document.getData().get("presupuesto");
                        double totalPresupuestoAAgregar = myTravel.getTotalPrice() * 0.7;
                        if(presupuestoAgenciaActual instanceof Long) {
                            docRef.update("presupuesto", (Long)presupuestoAgenciaActual + totalPresupuestoAAgregar);
                        } else if(presupuestoAgenciaActual instanceof Double) {
                            docRef.update("presupuesto", (Double)presupuestoAgenciaActual + totalPresupuestoAAgregar);
                        }
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }
}