package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tuckboxapp.DataModelPackage.Address;
import com.example.tuckboxapp.DataModelPackage.Cards;
import com.example.tuckboxapp.DataModelPackage.User;

public class AddAddress extends Menu {
    EditText editText,editText1;
    long insertionResult;
    public static final String ADDRESS_OBJECT = "ADDRESS_OBJECT";
    RecyclerView recyclerView1;
    User user;
    Address address;
    LinearLayout linearLayout;
    Button buttonAddaNewAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        address = (Address) getIntent().getSerializableExtra(AddAddress.ADDRESS_OBJECT) ;
        user =(User)getIntent().getSerializableExtra(MainActivity.USER_OBJECT);

        recyclerView1 = findViewById(R.id.address_list_recycler_view);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setAdapter(new AddressAdapter());

        insertionResult = -1;
        editText = findViewById(R.id.add_new_address_again);
        editText1 = findViewById(R.id.add_new_postal_code_again);
        linearLayout =findViewById(R.id.address_linear);
        buttonAddaNewAddress=findViewById(R.id.add_new_address);
    }

    public void orderCancelButtonClicked(View view) {
        finish();
    }

    public void placeOrderNextButtonClicked(View view) {

    }

    public void addANewAddressButtonClicked(View view) {
        buttonAddaNewAddress.setVisibility(View.GONE);
        linearLayout.setVisibility(View.VISIBLE);
    }

    public void cancelAddressButtonClicked(View view) {
        editText.setText(null);
        editText1.setText(null);
        linearLayout.setVisibility(View.GONE);
        buttonAddaNewAddress.setVisibility(View.VISIBLE);
    }

    public void saveAddressButtonClicked(View view) {
        if(editText.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Delivery address is required", Toast.LENGTH_LONG).show();
        }else {
            Address address = new Address();
            address.setAddress(editText.getText().toString());
            address.setPostalCode(editText1.getText().toString());
            address.setID(user.getID());

            InsertAddress insertAddress = new InsertAddress();
            insertAddress.execute(address);
        }
    }

    public class InsertAddress extends AsyncTask<Address,Void,Void>{

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
                finish();
            }
        }
    }
}
