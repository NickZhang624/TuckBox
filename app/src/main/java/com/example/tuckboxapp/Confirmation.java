package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuckboxapp.DataModelPackage.User;

import static com.example.tuckboxapp.PlaceOrder.EXTRA_ORDERED;

public class Confirmation extends Menu {

    TextView tvRgion,tvNote,tvOrdered,tvTime,tvAddress,tvPayment,tvCardDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        user =(User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);
        Intent i = getIntent();
        String region =i.getStringExtra(RegionAndDeliveryTime.EXTRA_REGION);
        String time = i.getStringExtra(RegionAndDeliveryTime.EXTRA_TIME);
        String note = i.getStringExtra(PlaceOrder.EXTRA_NOTE);
        String order = i.getStringExtra(EXTRA_ORDERED);
        String address = i.getStringExtra(OrderAddress.EXTRA_ADDRESS);
        String payment = i.getStringExtra(OrderPayment.EXTRA_CARD);
        String cardDate = i.getStringExtra(OrderPayment.EXTRA_CARDDATE);


        tvRgion =findViewById(R.id.con_region);
        tvNote =findViewById(R.id.con_note);
        tvTime =findViewById(R.id.con_time);
        tvAddress =findViewById(R.id.con_address);
        tvPayment = findViewById(R.id.con_payment);
        tvCardDate =findViewById(R.id.con_card_date);
        tvOrdered =findViewById(R.id.con_ordered);


        tvOrdered.setText("Ordered: \n"+ order);
        tvRgion.setText("Delivery Region: " + region);
        tvNote.setText("Customer Notes: " + note);
        tvTime.setText("Delivery Time: " + time);
        tvAddress.setText("Deliver Address: " + address);
        tvPayment.setText("Payment Card: " + payment);
        tvCardDate.setText(cardDate);
    }

    public void confirmCancelButtonClicked(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Order Cancellation");
        builder.setMessage("Are you want to cancel this order  ?");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cancelOrder();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void finalConfirmButtonClicked(View view) {
        Intent i = new Intent(this,AppServices.class);
        i.putExtra(MainActivity.USER_OBJECT,user);
        startActivity(i);
    }

    private void cancelOrder(){
        finish();
        Intent i = new Intent(this,AppServices.class);
        i.putExtra(MainActivity.USER_OBJECT,user);
        startActivity(i);
        Toast.makeText(getApplicationContext(),
                "Order Cancellation Successfully!",
                Toast.LENGTH_LONG).show();
    }
}
