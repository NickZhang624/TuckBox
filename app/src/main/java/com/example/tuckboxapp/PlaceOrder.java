package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.tuckboxapp.DataModelPackage.Address;
import com.example.tuckboxapp.DataModelPackage.User;

import java.util.ArrayList;
import java.util.List;

import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_REGION;
import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_TIME;

public class PlaceOrder extends Menu {
    User user;
    EditText etNote;
    TextView tvordered;
    Button buttonCancel,buttonNext,buttonAddNote;
    LinearLayout linearLayout;
    ElegantNumberButton elegantNumberButton1,elegantNumberButton2,elegantNumberButton3,elegantNumberButton4;
    Spinner spinner1,spinner2,spinner3,spinner4;

    public static final String EXTRA_NOTE ="EXTRA_NOTE";
    public static final String EXTRA_ORDERED ="EXTRA_ORDERED";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        user =(User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);

        buttonCancel = findViewById(R.id.btn_order_cancel);
        buttonNext =findViewById(R.id.btn_next_order);
        linearLayout=findViewById(R.id.linear_note);
        buttonAddNote=findViewById(R.id.add_a_note);
        etNote =findViewById(R.id.note);
        elegantNumberButton1=findViewById(R.id.number_button);
        elegantNumberButton2=findViewById(R.id.number_button1);
        elegantNumberButton3=findViewById(R.id.number_button2);
        elegantNumberButton4=findViewById(R.id.number_button3);
        tvordered=findViewById(R.id.ordered);
        spinner1=findViewById(R.id.spinner_salad);
        spinner2=findViewById(R.id.spinner_korma);
        spinner3=findViewById(R.id.spinner_sandwich);
        spinner4=findViewById(R.id.spinner_noodle);

    }

    public void orderCancelButtonClicked(View view) {
        finish();
    }

    public void placeOrderNextButtonClicked(View view) {
        String note =etNote.getText().toString();
        String order = tvordered.getText().toString();

        if(order.isEmpty()){
            Toast.makeText(getApplicationContext(),
                    "Please at least order one to continue", Toast.LENGTH_LONG).show();
        }else {
        Intent a = getIntent();
        String region =a.getStringExtra(EXTRA_REGION);
        String time = a.getStringExtra(EXTRA_TIME);

        Intent i = new Intent(this,OrderAddress.class);

        i.putExtra(EXTRA_REGION,region);
        i.putExtra(EXTRA_TIME,time);
        i.putExtra(EXTRA_NOTE,note);
        i.putExtra(EXTRA_ORDERED,order);
        i.putExtra(MainActivity.USER_OBJECT,user);

        startActivity(i);}
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
        String c = elegantNumberButton1.getNumber().trim();
        tvordered.append("Green Salad Lunch (" + s + ") * " + c + "\n");
    }

    public void button2ButtonClicked(View view) {
        String s = spinner2.getSelectedItem().toString();
        String c = elegantNumberButton2.getNumber().trim();
        tvordered.append("Lamb Korma (" + s + ") * " + c + "\n");
    }
    public void button3ButtonClicked(View view) {
        String s = spinner3.getSelectedItem().toString();
        String c = elegantNumberButton3.getNumber().trim();
        tvordered.append("Open Chicken Sandwich (" + s + ") * " + c + "\n");
    }
    public void button4ButtonClicked(View view) {
        String s = spinner4.getSelectedItem().toString();
        String c = elegantNumberButton4.getNumber().trim();
        tvordered.append("Beef Noodle Salad (" + s + ") * " + c + "\n");
    }

    public void clearButtonClicked(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Clear Ordered Item");
        builder.setMessage("Are you want to clear ALL ordered item ?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvordered.setText(null);
                Toast.makeText(getApplicationContext(),
                        "Ordered item has been cleared", Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
