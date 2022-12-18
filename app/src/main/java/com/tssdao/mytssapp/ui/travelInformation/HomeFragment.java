package com.tssdao.mytssapp.ui.travelInformation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tssdao.mytssapp.R;
import com.tssdao.mytssapp.SelectDestinyActivity;
import com.tssdao.mytssapp.WelcomeActivity;
import com.tssdao.mytssapp.databinding.FragmentTravelBinding;

public class HomeFragment extends Fragment {

    private FragmentTravelBinding binding;
    private Button btnEstado;
    private FirebaseFirestore db;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private TextView numPassenger;
    private TextView carComeFrom;
    private TextView precioTotal;
    private TextView tiempoLlegada;
    private TextView mensajeViaje;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentTravelBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //iniciar firebase
        db = FirebaseFirestore.getInstance();

        //iniciar shared preferences para obtener datos de viaje guardados en dispositivo
        sharedPreferences = getActivity().getSharedPreferences("mylocal", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        numPassenger = root.findViewById(R.id.num_passenger);
        numPassenger.setText(sharedPreferences.getString("D_numero_pasajeros", ""));

        carComeFrom = root.findViewById(R.id.car_come_from);
        carComeFrom.setText(sharedPreferences.getString("D_agencias", ""));

        precioTotal = root.findViewById(R.id.costo_de_viaje);
        precioTotal.setText(sharedPreferences.getString("D_costo_viaje", ""));

        tiempoLlegada = root.findViewById(R.id.tiempo_de_llegada);
        tiempoLlegada.setText(sharedPreferences.getString("D_tiempo_llegada", ""));

        mensajeViaje = (TextView) root.findViewById(R.id.mensaje_viaje);
        mensajeViaje.setText(sharedPreferences.getString("mensaje_viaje", ""));

        btnEstado = (Button) root.findViewById(R.id.btn_estado_viaje);
        btnEstado.setText(sharedPreferences.getString("btn_text", ""));

        btnEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnEstado.getText().equals("Confirmar llegada")) {
                    mensajeViaje.setText("Tu viaje comenzo :)");
                    btnEstado.setText("Terminar viaje");
                    editor.putString("mensaje_viaje", "Tu viaje comenzo :)");
                    editor.putString("btn_text", "Terminar viaje");
                    editor.apply();
                } else if(btnEstado.getText().equals("Terminar viaje")) {
                    mensajeViaje.setText("Hasta pronto :(");
                    btnEstado.setText("Nuevo viaje");
                    editor.putString("mensaje_viaje", "Hasta pronto :(");
                    editor.putString("btn_text", "Nuevo viaje");
                    editor.apply();
                    TextView cantidadView = (TextView)root.findViewById(R.id.num_passenger);
                    TextView agenciaView = (TextView)root.findViewById(R.id.car_come_from);
                    reponerVehiculosUsados(Integer.parseInt(cantidadView.getText().toString()), agenciaView.getText().toString());
                } else if(btnEstado.getText().equals("Nuevo viaje")) {
                    Intent intent = new Intent(getActivity(), WelcomeActivity.class);
                    startActivity(intent);
                }
            }
        });

        return root;
    }

    private void reponerVehiculosUsados(int cantidadPasajeros, String ubicacionAgencia) {
        String nombreAgencia = getNombreAgenciaPorUbicacion(ubicacionAgencia);
        int cantidadAutosEnviados = getCantidadAutosEnviados(cantidadPasajeros);
        DocumentReference docRef = db.collection("agencias").document(nombreAgencia);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Long cantidadAutosActual = (Long) document.getData().get("autos_disponibles");
                        docRef.update("autos_disponibles", cantidadAutosActual + cantidadAutosEnviados);
                    } else {
                        Log.d("MESSAGE", "No such document");
                    }
                } else {
                    Log.d("MESSAGE", "get failed with ", task.getException());
                }
            }
        });
    }

    private int getCantidadAutosEnviados(int cantidadPasajeros) {
        if(cantidadPasajeros >= 1 && cantidadPasajeros <= 5) {
            return 1;
        } else if(cantidadPasajeros >= 6 && cantidadPasajeros <= 10) {
            return 2;
        }else if(cantidadPasajeros >= 11 && cantidadPasajeros <= 15) {
            return 3;
        }else if(cantidadPasajeros >= 16 && cantidadPasajeros <= 20) {
            return 4;
        } else {
            return 0;
        }
    }

    private String getNombreAgenciaPorUbicacion(String ubicacion) {
        String nombre = "";
        switch (ubicacion) {
            case "Av. Ayacucho":
                nombre = "agencia1";
                break;
            case "C. Hamiraya":
                nombre = "agencia2";
                break;
            case "Av. Beneméritos":
                nombre = "agencia3";
                break;
            case "Av. José Ballivian":
                nombre = "agencia4";
                break;
            default:
                nombre = "";
        }
        return nombre;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}