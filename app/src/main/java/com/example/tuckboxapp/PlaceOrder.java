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

import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_REGION;
import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_TIME;

public class PlaceOrder extends Menu {
    User user;
    long insertionResult;

    EditText etNote;
    TextView evPayment, evAddress;
    Button buttonCancel,buttonNext;


    public static final String EXTRA_NOTE ="EXTRA_NOTE";


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

        etNote =findViewById(R.id.note);


    }

    public void orderCancelButtonClicked(View view) {
        Intent i = new Intent(this,AppServices.class);
        startActivity(i);
    }

    public void placeOrderNextButtonClicked(View view) {
        String note =etNote.getText().toString();
        Intent a = getIntent();
        String region =a.getStringExtra(EXTRA_REGION);
        String time = a.getStringExtra(EXTRA_TIME);
        Intent i = new Intent(this,Confirmation.class);
        i.putExtra(EXTRA_REGION,region);
        i.putExtra(EXTRA_TIME,time);
        i.putExtra(EXTRA_NOTE,note);

        startActivity(i);
    }
}
