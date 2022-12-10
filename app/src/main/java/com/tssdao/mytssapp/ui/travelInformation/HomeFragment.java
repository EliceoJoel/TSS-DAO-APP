package com.tssdao.mytssapp.ui.travelInformation;

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
import com.tssdao.mytssapp.R;
import com.tssdao.mytssapp.SelectDestinyActivity;
import com.tssdao.mytssapp.databinding.FragmentTravelBinding;

public class HomeFragment extends Fragment {

    private FragmentTravelBinding binding;

    private Button btnNuevoDestino;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentTravelBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        btnNuevoDestino = (Button) root.findViewById(R.id.btn_nuevo_destino);
        btnNuevoDestino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SelectDestinyActivity.class);
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