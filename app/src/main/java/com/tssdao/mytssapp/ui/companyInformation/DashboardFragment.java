package com.tssdao.mytssapp.ui.companyInformation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tssdao.mytssapp.R;
import com.tssdao.mytssapp.databinding.FragmentCompanyBinding;

public class DashboardFragment extends Fragment {

    private FragmentCompanyBinding binding;

    private LinearLayout infoAgency1;
    private Button btnAgency1;
    private LinearLayout infoAgency2;
    private Button btnAgency2;
    private LinearLayout infoAgency3;
    private Button btnAgency3;
    private LinearLayout infoAgency4;
    private Button btnAgency4;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentCompanyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        infoAgency1 = root.findViewById(R.id.info_agency1);
        btnAgency1 = root.findViewById(R.id.btn_agency1);
        addOnClickFunction(btnAgency1, infoAgency1, "1");

        infoAgency2 = root.findViewById(R.id.info_agency2);
        btnAgency2 = root.findViewById(R.id.btn_agency2);
        addOnClickFunction(btnAgency2, infoAgency2, "2");

        infoAgency3 = root.findViewById(R.id.info_agency3);
        btnAgency3 = root.findViewById(R.id.btn_agency3);
        addOnClickFunction(btnAgency3, infoAgency3, "3");

        infoAgency4 = root.findViewById(R.id.info_agency4);
        btnAgency4 = root.findViewById(R.id.btn_agency4);
        addOnClickFunction(btnAgency4, infoAgency4, "4");

        return root;
    }

    private void addOnClickFunction(Button btn, LinearLayout layout, String agencyNumber) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(layout.getVisibility() == View.GONE) {
                    btn.setText("Show less about Agencia " + agencyNumber);
                    //TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    layout.setVisibility(View.VISIBLE);
                } else {
                    btn.setText("Show more about Agencia " + agencyNumber);
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
}