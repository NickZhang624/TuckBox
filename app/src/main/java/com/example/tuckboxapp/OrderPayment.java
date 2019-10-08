package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.tuckboxapp.OrderAddress.EXTRA_ADDRESS;
import static com.example.tuckboxapp.PlaceOrder.EXTRA_NOTE;
import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_REGION;
import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_TIME;

public class OrderPayment extends AppCompatActivity {
    EditText tvCard;
    Button buttonCancel,buttonNext;
    public static final String EXTRA_CARD ="EXTRA_CARD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_payment);

        buttonCancel = findViewById(R.id.btn_order_cancel);
        buttonNext =findViewById(R.id.btn_next_order);

        tvCard =findViewById(R.id.order_credit_card);
    }

    public void orderCancelButtonClicked(View view) {
        Intent i = new Intent(this,OrderAddress.class);
        startActivity(i);
    }

    public void placeOrderNextButtonClicked(View view) {
        String card =tvCard.getText().toString();

        Intent a = getIntent();
        String region =a.getStringExtra(EXTRA_REGION);
        String time = a.getStringExtra(EXTRA_TIME);
        String note = a.getStringExtra(EXTRA_NOTE);
        String address = a.getStringExtra(EXTRA_ADDRESS);

        Intent i = new Intent(this,Confirmation.class);

        i.putExtra(EXTRA_REGION,region);
        i.putExtra(EXTRA_TIME,time);
        i.putExtra(EXTRA_NOTE,note);
        i.putExtra(EXTRA_ADDRESS,address);
        i.putExtra(EXTRA_CARD,card);

        startActivity(i);
    }
}
