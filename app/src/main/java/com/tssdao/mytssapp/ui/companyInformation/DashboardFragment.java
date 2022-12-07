package com.tssdao.mytssapp.ui.companyInformation;

import com.tssdao.mytssapp.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tssdao.mytssapp.AgenciesInformationActivity;
import com.tssdao.mytssapp.databinding.FragmentCompanyBinding;

public class DashboardFragment extends Fragment {

    private Button btnAgencias;
    private FragmentCompanyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_company, container, false);
        binding = FragmentCompanyBinding.inflate(inflater, container, false);
        //View root = binding.getRoot();
        btnAgencias = (Button) root.findViewById(R.id.btn_agencias);
        btnAgencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AgenciesInformationActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}