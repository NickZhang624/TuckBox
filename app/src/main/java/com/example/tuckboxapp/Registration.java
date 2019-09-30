package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tuckboxapp.DataModelPackage.User;

public class Registration extends AppCompatActivity {

    long insertionResult;
    EditText etFName, etLName, etUName, etPassword, etMobile, etEmail, etAddress, etCardNumber,
    etExpiredDate;
    Spinner spTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        insertionResult = -1;
        spTitle = findViewById(R.id.spinner_reg_title);
        etFName = findViewById(R.id.edit_reg_first_name);
        etLName = findViewById(R.id.edit_reg_last_name);
        etUName = findViewById(R.id.edit_reg_user_name);
        etPassword = findViewById(R.id.edit_reg_password);
        etMobile = findViewById(R.id.edit_reg_mob_num);
        etEmail= findViewById(R.id.edit_reg_email);
        etAddress= findViewById(R.id.edit_reg_adress);
        etCardNumber= findViewById(R.id.edit_reg_credit_card);
        etExpiredDate= findViewById(R.id.edit_reg_expired_date);


    }

    public void registrationCancelButtonClicked(View view) {
        finishActivity();
    }

    private void finishActivity() {
        finish();
    }

    public void registerClicked(View view) {
        if(etFName.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "First Name is required", Toast.LENGTH_LONG).show();
        } else if (etLName.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Last Name is required", Toast.LENGTH_LONG).show();
        } else if(etUName.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "User Name is required", Toast.LENGTH_LONG).show();
        } else if(etPassword.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Password is required", Toast.LENGTH_LONG).show();
        } else if(etMobile.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Mobile Number is required", Toast.LENGTH_LONG).show();
        } else if(etEmail.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Email is required", Toast.LENGTH_LONG).show();
        }else if(etAddress.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Address is required", Toast.LENGTH_LONG).show();
        }else if(etCardNumber.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Credit Card is required", Toast.LENGTH_LONG).show();
        }else if(etExpiredDate.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Card Expired Date is required", Toast.LENGTH_LONG).show();
        } else {
            // we going create a Student object and fill all these info in the object
            User user = new User();
            user.setTitle(spTitle.getSelectedItem().toString());
            user.setFirstName(etFName.getText().toString());
            user.setLastName(etLName.getText().toString());
            user.setUserName(etUName.getText().toString());
            user.setPassword(etPassword.getText().toString());
            user.setMobileNumber(etMobile.getText().toString());
            user.setEmail(etEmail.getText().toString());
            user.setDeliveryAddress(etAddress.getText().toString());

            String str = etCardNumber.getText().toString();
//            if ()
            user.setCreditNumber(etCardNumber.getText().toString());
            user.setExpiredDate(etExpiredDate.getText().toString());

            InsertUser insertUser = new InsertUser();
            insertUser.execute(user);

        }
    }

    public class InsertUser extends AsyncTask<User,Void,Void>{

        @Override
        protected Void doInBackground(User... users) {
            insertionResult = MainActivity.userDao.insertUser(users[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(insertionResult == -1){
                Toast.makeText(getApplicationContext(),
                        "Error: User registration failed, please try again.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Create Successful! Please login in using our service", Toast.LENGTH_LONG).show();
                finishActivity();
            }
        }

    }
}
