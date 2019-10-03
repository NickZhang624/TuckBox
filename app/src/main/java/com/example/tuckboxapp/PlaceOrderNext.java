package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlaceOrderNext extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order_next);
    }

    public void orderNextCancelButtonClicked(View view) {
        Intent i = new Intent(this,AppServices.class);
        startActivity(i);
    }

    public void orderConfirmButtonClicked(View view) {
        Intent i = new Intent(this,Confirmation.class);
        startActivity(i);
    }
}
