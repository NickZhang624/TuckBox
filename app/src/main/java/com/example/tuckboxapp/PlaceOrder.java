package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class PlaceOrder extends Menu {

    long insertionResult;
    Spinner spinnerRegion, spinnerTime;
    EditText etNote;
    TextView etPayment, etAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        insertionResult = -1;
        etNote =findViewById(R.id.note);
        etPayment =findViewById(R.id.order_show_credit_card);
        etAddress =findViewById(R.id.order_show_address);
        spinnerRegion =findViewById(R.id.spinner_order_region);
        spinnerTime = findViewById(R.id.spinner_time);
    }

    public void orderCancelButtonClicked(View view) {
        Intent i = new Intent(this,AppServices.class);
        startActivity(i);
    }

    public void placeOrderNextButtonClicked(View view) {
        Intent i = new Intent(this,Confirmation.class);
        startActivity(i);
    }
}
