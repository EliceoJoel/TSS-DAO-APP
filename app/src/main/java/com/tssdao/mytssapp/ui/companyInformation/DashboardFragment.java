package com.tssdao.mytssapp.ui.companyInformation;

import static android.content.ContentValues.TAG;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.tssdao.mytssapp.R;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.tssdao.mytssapp.AgenciesInformationActivity;
import com.tssdao.mytssapp.databinding.FragmentCompanyBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DashboardFragment extends Fragment {

    FirebaseFirestore db;

    //PDFs
    String NOMBRE_DIRECTORIO = "MyTSSApp";
    String NOMBRE_DOCUMENTO = "intelliCar.pdf";
    Button btnGenerar;


    private Button btnAgencias;
    private FragmentCompanyBinding binding;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private LinearLayout infoAgency1;
    private Button btnAgency1;
    private LinearLayout infoAgency2;
    private Button btnAgency2;
    private LinearLayout infoAgency3;
    private Button btnAgency3;
    private LinearLayout infoAgency4;
    private Button btnAgency4;

    private TextView infoAg1;
    private TextView infoAg2;
    private TextView infoAg3;
    private TextView infoAg4;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        db = FirebaseFirestore.getInstance();


        View root = inflater.inflate(R.layout.fragment_company, container, false);
        binding = FragmentCompanyBinding.inflate(inflater, container, false);
        btnGenerar =  (Button) root.findViewById(R.id.btnCrearPdf);
        btnAgencias = (Button) root.findViewById(R.id.own_agencies);
        btnAgencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AgenciesInformationActivity.class);
                startActivity(intent);
            }
        });


        // Genera el documento
        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extraerTotal("informacion_empresa","ganancia");
                //Toast.makeText(myActivity.this, "SE CREO EL PDF", Toast.LENGTH_LONG).show();
            }
        });

        infoAgency1 = root.findViewById(R.id.info_agency1);
        btnAgency1 = root.findViewById(R.id.btn_agency1);
        infoAg1 = root.findViewById(R.id.budget_agency1);
        addOnClickFunction(btnAgency1, infoAgency1, "1",infoAg1,"agencia1");

        infoAgency2 = root.findViewById(R.id.info_agency2);
        btnAgency2 = root.findViewById(R.id.btn_agency2);
        infoAg2 = root.findViewById(R.id.budget_agency2);
        addOnClickFunction(btnAgency2, infoAgency2, "2",infoAg2,"agencia2");

        infoAgency3 = root.findViewById(R.id.info_agency3);
        btnAgency3 = root.findViewById(R.id.btn_agency3);
        infoAg3 = root.findViewById(R.id.budget_agency3);
        addOnClickFunction(btnAgency3, infoAgency3, "3",infoAg3, "agencia3");

        infoAgency4 = root.findViewById(R.id.info_agency4);
        btnAgency4 = root.findViewById(R.id.btn_agency4);
        infoAg4 = root.findViewById(R.id.budget_agency4);
        addOnClickFunction(btnAgency4, infoAgency4, "4",infoAg4,"agencia4");

        renderizarPrecio(root);



        return root;
    }

    private void renderizarPrecio(View root) {
        sharedPreferences = this.getActivity().getSharedPreferences("mylocal", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        TextView totalview = root.findViewById(R.id.totalGanancias);
        totalview.setText(sharedPreferences.getString("precio_total_string", ""));
    }

    private void addOnClickFunction(Button btn, LinearLayout layout, String agencyNumber, TextView infoAg, String id) {


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(layout.getVisibility() == View.GONE) {
                    btn.setText("Mostrar menos de Agencia " + agencyNumber);
                    leer(infoAg,id);
                    //TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    layout.setVisibility(View.VISIBLE);
                } else {
                    btn.setText("Mostrar mas de Agencia " + agencyNumber);
                    //TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    layout.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public String ordenar(DocumentSnapshot snapshot){

        String numA = snapshot.getData().get("numero").toString();
        String dispo = snapshot.getData().get("autos_disponibles").toString();
        String ubicacion = snapshot.getData().get("ubicacion").toString();
        String presupuesto = snapshot.getData().get("presupuesto").toString();

        return  "Disponibilidad de vehiculos: " + dispo + "\n" + "Numero Agencia: " + numA + "\n" + "Ubicacion de la agencia: " + ubicacion + "\n" +"Presupuesto para reparacion: " + presupuesto;

    }

    public void leer(TextView infoAg, String id){
        final DocumentReference docRef = db.collection("agencias").document(id);
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e);
                    return;
                }

                if (snapshot != null && snapshot.exists()) {
                    String infoEmpresa = ordenar(snapshot);
                    infoAg.setText(infoEmpresa);
                } else {
                    Log.d(TAG, "Current data: null");
                }
            }
        });
    }


    public void crearPDF(String infoEmpresaTotal, String InfoAgencias) {
        Document documento = new Document();

        try {
            File file = crearFichero(NOMBRE_DOCUMENTO);
            FileOutputStream ficheroPDF = new FileOutputStream(file.getAbsolutePath());

            PdfWriter writer = PdfWriter.getInstance(documento, ficheroPDF);

            documento.open();

            documento.add(new Paragraph("                                                 INFORMACION DE LA EMPRESA \n\n"));
            documento.add(new Paragraph("Total Ganancias \n"));
            documento.add(new Paragraph( infoEmpresaTotal + "  Bs \n\n"));
            documento.add(new Paragraph("                                                               AGENCIAS \n"));
            documento.add(new Paragraph( InfoAgencias));


        } catch(DocumentException e) {
        } catch(IOException e) {
        } finally {
            documento.close();
        }
    }
    public File crearFichero(String nombreFichero) {
        File ruta = getRuta();

        File fichero = null;
        if(ruta != null) {
            fichero = new File(ruta, nombreFichero);
        }

        return fichero;
    }

    public File getRuta() {
        File ruta = null;

        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            ruta = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), NOMBRE_DIRECTORIO);

            if(ruta != null) {
                if(!ruta.mkdirs()) {
                    if(!ruta.exists()) {
                        return null;
                    }
                }
            }

        }
        return ruta;
    }

    public void extraerTotal(String idColeccion, String idDoc){
        final DocumentReference docRef = db.collection(idColeccion).document(idDoc);
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e);
                    return;
                }

                if (snapshot != null && snapshot.exists()) {
                    String infoTotal = snapshot.getData().get("total").toString();
                    extraerInfoAgencias(infoTotal,"agencias");

                } else {
                    Log.d(TAG, "Current data: null");
                }
            }
        });
    }

    public void extraerInfoAgencias(String informacioTotal,String idColeccion){
        db.collection(idColeccion)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            String texto= "";
                            int n=1;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                   texto += "AGENCIA " + n +"\n" + reacomodar(document);
                                   n++;
                            }
                        crearPDF(informacioTotal,texto);
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
    public String reacomodar(QueryDocumentSnapshot document){


        String c1 = document.getData().get("autos_disponibles").toString();
        String c2 = document.getData().get("numero").toString();
        String c3 = document.getData().get("ubicacion").toString();
        String c4 = document.getData().get("presupuesto").toString() + "  Bs";

        return  "Disponibilidad de vehiculos: " + c1 + "\n" + "Numero Agencia: " + c2 + "\n" + "Ubicacion de la agencia: " + c3 + "\n" +"Presupuesto para reparacion: " + c4 +"\n \n";


    }

}