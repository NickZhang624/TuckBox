package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Confirmation extends Menu {

    TextView tvRgion,tvNote,tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        Intent i = getIntent();
        String region =i.getStringExtra(PlaceOrder.EXTRA_REGION);
        String note = i.getStringExtra(PlaceOrder.EXTRA_NOTE);
        String time = i.getStringExtra(PlaceOrder.EXTRA_TIME);

        tvRgion =findViewById(R.id.con_region);
        tvNote =findViewById(R.id.con_note);
        tvTime =findViewById(R.id.con_time);

        tvRgion.setText("Delivery Region: " + region);
        tvNote.setText("Customer Notes: " + note);
        tvTime.setText("Delivery Time: " + time);
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
