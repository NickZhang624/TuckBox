package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddAddress extends Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
    }

    public void orderCancelButtonClicked(View view) {
        finish();
        Intent i = new Intent(this,UserListView.class);
        startActivity(i);
    }

    public void placeOrderNextButtonClicked(View view) {
    }
}
