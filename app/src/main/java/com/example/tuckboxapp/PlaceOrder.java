package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.tuckboxapp.DataModelPackage.User;

import java.util.ArrayList;
import java.util.List;

import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_REGION;
import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_TIME;

public class PlaceOrder extends Menu {
    User user;
    long insertionResult;
    EditText etNote;
    TextView evPayment, evAddress,tvordered;
    Button buttonCancel,buttonNext,buttonAddNote;
    LinearLayout linearLayout;
    ElegantNumberButton elegantNumberButton;
    Spinner spinner1;

    public static final String EXTRA_NOTE ="EXTRA_NOTE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        user =(User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);

//        evPayment =findViewById(R.id.order_show_credit_card);
//        evAddress =findViewById(R.id.order_show_address);

        buttonCancel = findViewById(R.id.btn_order_cancel);
        buttonNext =findViewById(R.id.btn_next_order);
        linearLayout=findViewById(R.id.linear_note);
        buttonAddNote=findViewById(R.id.add_a_note);
        etNote =findViewById(R.id.note);
        elegantNumberButton=findViewById(R.id.number_button);
        tvordered=findViewById(R.id.ordered);
        spinner1=findViewById(R.id.spinner_salad);


    }

    public void orderCancelButtonClicked(View view) {
        finish();
    }

    public void placeOrderNextButtonClicked(View view) {
        String note =etNote.getText().toString();

        Intent a = getIntent();
        String region =a.getStringExtra(EXTRA_REGION);
        String time = a.getStringExtra(EXTRA_TIME);

        Intent i = new Intent(this,OrderAddress.class);

        i.putExtra(EXTRA_REGION,region);
        i.putExtra(EXTRA_TIME,time);
        i.putExtra(EXTRA_NOTE,note);
        i.putExtra(MainActivity.USER_OBJECT,user);

        startActivity(i);
    }

    public void addANewNoteButtonClicked(View view) {
        linearLayout.setVisibility(View.VISIBLE);
        buttonAddNote.setVisibility(View.GONE);
    }

    public void cancel_noteButtonClicked(View view) {
        buttonAddNote.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.GONE);
        etNote.setText(null);
    }

    public void button1ButtonClicked(View view) {
        String s = spinner1.getSelectedItem().toString();
        String c = elegantNumberButton.getNumber().trim();

        tvordered.setText("Green Salad Lunch (" + s + ") * " + c );

    }
}
