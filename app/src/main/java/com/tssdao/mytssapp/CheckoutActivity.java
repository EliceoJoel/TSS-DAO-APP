package com.tssdao.mytssapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    MyTravel myTravel;
    private Button btnPayAndStartTravel;
    private EditText cardNumber;
    private EditText cardExpirationMonth;
    private EditText cardExpirationYear;
    private EditText cardCVC;
    private TextView numberError;
    private TextView monthError;
    private TextView yearError;
    private TextView cvcError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        myTravel = (MyTravel) getIntent().getSerializableExtra(MyTravel.PREFIX);
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

        btnPayAndStartTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearErrors();
                if(cardValidation()) {
                    Intent intent = new Intent(CheckoutActivity.this, TravelInformationToBeMadeActivity.class);
                    intent.putExtra(MyTravel.PREFIX, myTravel);
                    intent.putExtra(WelcomeActivity.PASSENGER_NUM_PREFIX, getIntent().getIntExtra(WelcomeActivity.PASSENGER_NUM_PREFIX, 1));
                    intent.putExtra(TravelInformationActivity.CAR_COME_FROM_PREFIX, getIntent().getStringExtra(TravelInformationActivity.CAR_COME_FROM_PREFIX));
                    intent.putExtra(TravelInformationActivity.tiempoLlegada, getIntent().getStringExtra(TravelInformationActivity.tiempoLlegada));
                    intent.putExtra(SelectDestinyActivity.COSTO_DEL_VIAJE, getIntent().getStringExtra(SelectDestinyActivity.COSTO_DEL_VIAJE));
                    startActivity(intent);
                }
            }
        });
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
}