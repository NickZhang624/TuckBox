package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Confirmation extends Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
    }

    public void confirmCancelButtonClicked(View view) {
        Intent i = new Intent(this,AppServices.class);
        startActivity(i);
    }

    public void finalConfirmButtonClicked(View view) {
        Intent i = new Intent(this,AppServices.class);
        startActivity(i);
    }
}
