package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.example.tuckboxapp.DataModelPackage.User;

public class RegionAndDeliveryTime extends Menu {
    Button buttonCancel,buttonNext;
    Spinner spinnerRegion, spinnerTime;

    public static final String EXTRA_REGION ="EXTRA_REGION";
    public static final String EXTRA_TIME ="EXTRA_TIME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_and_delivery_time);

        buttonCancel = findViewById(R.id.btn_order_cancel);
        buttonNext =findViewById(R.id.btn_next_order);
        spinnerRegion =findViewById(R.id.spinner_order_region);
        spinnerTime = findViewById(R.id.spinner_time);
    }

    public void orderCancelButtonClicked(View view) {
        Intent a = new Intent(this,AppServices.class);
        startActivity(a);
    }

    public void placeOrderNextButtonClicked(View view) {
        String region = spinnerRegion.getSelectedItem().toString();
        String time = spinnerTime.getSelectedItem().toString();
        Intent i = new Intent(this,PlaceOrder.class);
        i.putExtra(EXTRA_REGION,region);
        i.putExtra(EXTRA_TIME,time);
        startActivity(i);

    }
}
