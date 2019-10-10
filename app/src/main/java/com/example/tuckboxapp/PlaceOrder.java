package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
    Button buttonCancel,buttonNext,buttonAddNote;
    LinearLayout linearLayout;


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
        linearLayout=findViewById(R.id.linear_note);
        buttonAddNote=findViewById(R.id.add_a_note);
        etNote =findViewById(R.id.note);


    }

    public void orderCancelButtonClicked(View view) {
        Intent i = new Intent(this,RegionAndDeliveryTime.class);
        startActivity(i);
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
}
