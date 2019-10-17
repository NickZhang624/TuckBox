package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuckboxapp.DataModelPackage.Address;
import com.example.tuckboxapp.DataModelPackage.Cards;
import com.example.tuckboxapp.DataModelPackage.User;

import static com.example.tuckboxapp.PlaceOrder.EXTRA_NOTE;
import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_REGION;
import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_TIME;

public class OrderAddress extends Menu {
    TextView text,text1,tvAsking;
    Button buttonCancel,buttonNext,buttonAddANewAddress;
    CheckBox cb1,cb2,cb3;
    Spinner spinner;
    EditText etaddress,etcode;
    LinearLayout linearLayout;
    ConstraintLayout constraintLayout;
    long insertionResult;

    public static final String EXTRA_ADDRESS ="EXTRA_ADDRESS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_address);
        user =(User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);
        text =findViewById(R.id.order_address);
        cb1 =findViewById(R.id.checkBox);
        cb1.setChecked(true);

        //spinner=findViewById(R.id.spinner_address);
        //cb2=findViewById(R.id.checkBox1);

        constraintLayout=findViewById(R.id.new_address_cons);
        text1=findViewById(R.id.new_delivery_address);
        cb3=findViewById(R.id.checkBox3);

        tvAsking=findViewById(R.id.asking);
        buttonAddANewAddress=findViewById(R.id.add_a_new_address);

        etaddress=findViewById(R.id.new_address_again);
        etcode=findViewById(R.id.new_postal_code_again);

        linearLayout=findViewById(R.id.address_linear);

        buttonCancel = findViewById(R.id.btn_order_cancel);
        buttonNext =findViewById(R.id.btn_next_order);


    }

    public void orderCancelButtonClicked(View view) {
        finish();
    }

    public void placeOrderNextButtonClicked(View view) {
        String address =text.getText().toString();
        String address1 = text1.getText().toString();

        Intent a = getIntent();
        String region =a.getStringExtra(EXTRA_REGION);
        String time = a.getStringExtra(EXTRA_TIME);
        String note = a.getStringExtra(EXTRA_NOTE);


        if(cb1.isChecked() && !cb3.isChecked()){
            Intent i = new Intent(this,OrderPayment.class);
            i.putExtra(EXTRA_REGION,region);
            i.putExtra(EXTRA_TIME,time);
            i.putExtra(EXTRA_NOTE,note);
            i.putExtra(EXTRA_ADDRESS,address);
            i.putExtra(MainActivity.USER_OBJECT,user);
            startActivity(i);
        }else if(cb3.isChecked() && !cb1.isChecked()){
            Intent i = new Intent(this,OrderPayment.class);
            i.putExtra(EXTRA_REGION,region);
            i.putExtra(EXTRA_TIME,time);
            i.putExtra(EXTRA_NOTE,note);
            i.putExtra(EXTRA_ADDRESS,address1);
            i.putExtra(MainActivity.USER_OBJECT,user);
            startActivity(i);
        }else if(cb1.isChecked() && cb1.isChecked()){
            Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
        }else if( !cb1.isChecked() && !cb3.isChecked()){
            Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
        }

    }

    public void addANewAddressButtonClicked(View view) {
        buttonAddANewAddress.setVisibility(View.GONE);
        linearLayout.setVisibility(View.VISIBLE);
    }

    public void cancelAddressButtonClicked(View view) {
        etaddress.setText(null);
        etcode.setText(null);
        linearLayout.setVisibility(View.GONE);
        buttonAddANewAddress.setVisibility(View.VISIBLE);
    }

    public void saveAddressButtonClicked(View view) {
        if(etaddress.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Delivery address is required", Toast.LENGTH_LONG).show();
        }else {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Remember Address");
            builder.setMessage("Are you want to save this address into your account for further using ?");

            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Address address = new Address();
                    address.setAddress(etaddress.getText().toString());
                    address.setPostalCode(etcode.getText().toString());
                    address.setID(user.getID());
                    cb3.setChecked(true);
                    tvAsking.setVisibility(View.GONE);
                    cb1.setChecked(false);

                    InsertAddress insertAddress = new InsertAddress();
                    insertAddress.execute(address);

                }
            });

            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    getInfo();
                    Toast.makeText(getApplicationContext(),
                            "Not remember address into your profile, ONLY use this time", Toast.LENGTH_LONG).show();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }
    }

    public class InsertAddress extends AsyncTask<Address,Void,Void> {

        @Override
        protected Void doInBackground(Address... addresses) {
            insertionResult = MainActivity.userDao.insertaddress(addresses[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(insertionResult == -1){
                Toast.makeText(getApplicationContext(),
                        "Error: add address failed, please try it again.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Add address Successful!", Toast.LENGTH_LONG).show();
                getInfo();
            }
        }
    }


    public void getInfo(){
        String address = etaddress.getText().toString();
        linearLayout.setVisibility(View.GONE);
        buttonAddANewAddress.setVisibility(View.GONE);
        constraintLayout.setVisibility(View.VISIBLE);
        text1.setText(address);
        cb3.setChecked(true);
        tvAsking.setVisibility(View.GONE);
        cb1.setChecked(false);
    }
}
