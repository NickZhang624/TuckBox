package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tuckboxapp.DataModelPackage.Address;
import com.example.tuckboxapp.DataModelPackage.Cards;
import com.example.tuckboxapp.DataModelPackage.User;

public class AddressEdit extends AppCompatActivity {
    EditText etaddress,etcode;
    int updateResult,deleteResult;
    User user;
    Address address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_edit);
        address = (Address) getIntent().getSerializableExtra(AddAddress.ADDRESS_OBJECT);
        user = (User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);

        updateResult = -1;
        deleteResult = -1;
        etaddress=findViewById(R.id.address_edit_address);
        etcode=findViewById(R.id.address_edit_postal_code);
        etaddress.setText(address.getAddress());
        etcode.setText(address.getPostalCode());
        setUIBehaviors();
    }

    private void setUIBehaviors(){
        etaddress.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!etaddress.getText().toString().equals(address.getAddress())){
                        address.setAddress(etaddress.getText().toString());
                    }
                }else
                    etaddress.selectAll();
            }
        });
        etcode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!etcode.getText().toString().equals(address.getPostalCode())){
                        address.setPostalCode(etcode.getText().toString());
                    }else
                        etcode.selectAll();
                }
            }
        });
    }

    public void updateButtonClicked(View view) {
        if(etaddress.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Address is required", Toast.LENGTH_LONG).show();
        } else {
            new UpdateAddress().execute(address);
        }
    }

    public class UpdateAddress extends AsyncTask<Address,Void,Void> {
        @Override
        protected Void doInBackground(Address... addresses) {
            updateResult = MainActivity.userDao.updateaddress(addresses[0]);
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(updateResult == -1){
                Toast.makeText(getApplicationContext(),
                        "Error: update cards failed, please try it again.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "update address Successful!", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

    public void deleteButtonClicked(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete Address");
        builder.setMessage("Are you want to delete address ?");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new DeleteAddress().execute(address);}
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private class DeleteAddress extends AsyncTask<Address,Void,Void> {
        @Override
        protected Void doInBackground(Address... addresses) {
            deleteResult = MainActivity.userDao.deleteaddress(addresses[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(deleteResult == 1){
                Toast.makeText(getApplicationContext(),
                        "Delete Successfully!",
                        Toast.LENGTH_LONG).show();
                finish();
            } else{
                Toast.makeText(getApplicationContext(),
                        "Please try again or contact us for further requirement",
                        Toast.LENGTH_LONG).show();}
        }
    }

    public void CancelButtonClicked(View view) {
        finish();
    }
}
