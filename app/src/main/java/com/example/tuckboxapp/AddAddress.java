package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tuckboxapp.DataModelPackage.Address;
import com.example.tuckboxapp.DataModelPackage.Cards;

public class AddAddress extends Menu {
    EditText editText;
    long insertionResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        insertionResult = -1;
        editText = findViewById(R.id.new_address);
    }

    public void orderCancelButtonClicked(View view) {
        finish();
        Intent i = new Intent(this,UserListView.class);
        startActivity(i);
    }

    public void placeOrderNextButtonClicked(View view) {
        if(editText.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Delivery address is required", Toast.LENGTH_LONG).show();
        }else {
            Address address =new Address();
            address.setAddress(editText.getText().toString());

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
                finishActivity();
            }
        }
    }

    private void finishActivity() {
        finish();
        Intent i = new Intent(this,AppServices.class);
        startActivity(i);
    }
}
