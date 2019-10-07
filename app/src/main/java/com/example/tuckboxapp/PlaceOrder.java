package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tuckboxapp.DataModelPackage.User;

public class PlaceOrder extends Menu {
    User user;
    long insertionResult;
    Spinner spinnerRegion, spinnerTime;
    EditText etNote;
    TextView evPayment, evAddress;
    Button buttonCancel,buttonNext;

    public static final String EXTRA_REGION ="EXTRA_REGION";
    public static final String EXTRA_NOTE ="EXTRA_NOTE";
    public static final String EXTRA_TIME ="EXTRA_TIME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
//        user = (User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);
//
//        insertionResult = -1;
//
//        evPayment =findViewById(R.id.order_show_credit_card);
//        evAddress =findViewById(R.id.order_show_address);



        buttonCancel = findViewById(R.id.btn_order_cancel);
        buttonNext =findViewById(R.id.btn_next_order);
        spinnerRegion =findViewById(R.id.spinner_order_region);
        etNote =findViewById(R.id.note);
        spinnerTime = findViewById(R.id.spinner_time);
    }

    public void orderCancelButtonClicked(View view) {
        Intent i = new Intent(this,AppServices.class);
        startActivity(i);
    }

    public void placeOrderNextButtonClicked(View view) {
        String region = spinnerRegion.getSelectedItem().toString();
        String note =etNote.getText().toString();
        String time = spinnerTime.getSelectedItem().toString();
        Intent i = new Intent(this,Confirmation.class);
        i.putExtra(EXTRA_REGION,region);
        i.putExtra(EXTRA_NOTE,note);
        i.putExtra(EXTRA_TIME,time);
        startActivity(i);
    }
}
