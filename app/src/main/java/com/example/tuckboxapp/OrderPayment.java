package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.tuckboxapp.OrderAddress.EXTRA_ADDRESS;
import static com.example.tuckboxapp.PlaceOrder.EXTRA_NOTE;
import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_REGION;
import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_TIME;

public class OrderPayment extends AppCompatActivity {
    TextView tvCard;
    Button buttonCancel,buttonNext;
    LinearLayout linearLayout;
    ConstraintLayout constraintLayout;
    public static final String EXTRA_CARD ="EXTRA_CARD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_payment);

        buttonCancel = findViewById(R.id.btn_order_cancel);
        buttonNext =findViewById(R.id.btn_next_order);
        linearLayout =findViewById(R.id.payment_linear);
        tvCard =findViewById(R.id.order_credit_card);
        constraintLayout =findViewById(R.id.new_payment_cons);
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

    public void addANewCardButtonClicked(View view) {
        linearLayout.setVisibility(View.VISIBLE);
    }

    public void cancelPaymentButtonClicked(View view) {
        linearLayout.setVisibility(View.GONE);
    }

    public void savePaymentButtonClicked(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remember Card");
        builder.setMessage("Are you want to save this card into your account for further using ?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),
                        "Save it successfully!.", Toast.LENGTH_LONG).show();
                linearLayout.setVisibility(View.GONE);

            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                linearLayout.setVisibility(View.GONE);
                constraintLayout.setVisibility(View.VISIBLE);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
