package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.tuckboxapp.PlaceOrder.EXTRA_NOTE;
import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_REGION;
import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_TIME;

public class OrderAddress extends Menu {
    EditText text;
    Button buttonCancel,buttonNext;

    public static final String EXTRA_ADDRESS ="EXTRA_ADDRESS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_address);

        buttonCancel = findViewById(R.id.btn_order_cancel);
        buttonNext =findViewById(R.id.btn_next_order);

        text =findViewById(R.id.order_address);
    }

    public void orderCancelButtonClicked(View view) {
        Intent i = new Intent(this,PlaceOrder.class);
        startActivity(i);
    }

    public void placeOrderNextButtonClicked(View view) {
        String address =text.getText().toString();

        Intent a = getIntent();
        String region =a.getStringExtra(EXTRA_REGION);
        String time = a.getStringExtra(EXTRA_TIME);
        String note = a.getStringExtra(EXTRA_NOTE);

        Intent i = new Intent(this,OrderPayment.class);

        i.putExtra(EXTRA_REGION,region);
        i.putExtra(EXTRA_TIME,time);
        i.putExtra(EXTRA_NOTE,note);
        i.putExtra(EXTRA_ADDRESS,address);

        startActivity(i);
    }
}
