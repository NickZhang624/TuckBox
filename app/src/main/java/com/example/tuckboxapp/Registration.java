package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

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
        etUName = findViewById(R.id.edit_user_name_login);
        etPassword = findViewById(R.id.edit_password_login);
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
    }
}
