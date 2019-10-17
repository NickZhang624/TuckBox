package com.example.tuckboxapp;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuckboxapp.DataModelPackage.User;

import java.util.Calendar;

public class UserUpdateInfo extends Menu {
    User user;
    EditText etUPFname,etUPLname,etUPUname,etUPPassword,etUPMobile,etUPEmail,
            etUPDeliveryAddress,etUPCard;
    Spinner etUPTitle;
    TextView etUPExpiredDate;

    int updateResult,deleteResult;

    DatePickerDialog.OnDateSetListener mDate;
    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update_info);

        user =(User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);

        updateResult = -1;
        deleteResult = -1;

        etUPTitle=findViewById(R.id.spinner_up_title);
        etUPFname=findViewById(R.id.edit_up_first_name);
        etUPLname=findViewById(R.id.edit_up_last_name);
        etUPUname=findViewById(R.id.edit_up_user_name);
        etUPPassword=findViewById(R.id.edit_up_password);
        etUPMobile=findViewById(R.id.edit_up_mob_num);
        etUPEmail=findViewById(R.id.edit_up_email);
        etUPDeliveryAddress=findViewById(R.id.edit_up_adress);
        etUPCard=findViewById(R.id.edit_up_credit_card);
        etUPExpiredDate=findViewById(R.id.edit_up_expired_date);


        if(!etUPTitle.getSelectedItem().toString().equals(user.getTitle())){
            etUPTitle.setSelection(1);
        }
        etUPFname.setText(user.getFirstName());
        etUPLname.setText(user.getLastName());
        etUPUname.setText(user.getUserName());
        etUPPassword.setText(user.getPassword());
        etUPMobile.setText(user.getMobileNumber());
        etUPEmail.setText(user.getEmail());
        etUPDeliveryAddress.setText(user.getDeliveryAddress());
        etUPCard.setText(user.getCreditNumber());
        etUPExpiredDate.setText(user.getExpiredDate());

        setUIBehaviors();

        etUPExpiredDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        UserUpdateInfo.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDate,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = month + "/" + dayOfMonth + "/" + year;
                etUPExpiredDate.setText(date);
            }
        };

    }

    private void setUIBehaviors() {
        etUPTitle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(!etUPTitle.getSelectedItem().toString().equals(user.getTitle())){
                    user.setTitle(etUPTitle.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        etUPFname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!etUPFname.getText().toString().equals(user.getFirstName())){
                        user.setFirstName(etUPFname.getText().toString());
                    }
                } else
                    etUPFname.selectAll();
            }
        });
        etUPLname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!etUPLname.getText().toString().equals(user.getLastName())){
                        user.setLastName(etUPLname.getText().toString());
                    }
                } else
                    etUPLname.selectAll();
            }
        });
        etUPUname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!etUPUname.getText().toString().equals(user.getUserName())){
                        user.setUserName(etUPUname.getText().toString());
                    }
                } else
                    etUPUname.selectAll();
            }
        });
        etUPPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!etUPPassword.getText().toString().equals(user.getPassword())){
                        user.setPassword(etUPPassword.getText().toString());
                    }
                } else
                    etUPPassword.selectAll();
            }
        });
        etUPMobile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!etUPMobile.getText().toString().equals(user.getMobileNumber())){
                        user.setMobileNumber(etUPMobile.getText().toString());
                    }
                } else
                    etUPMobile.selectAll();
            }
        });
        etUPEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!etUPEmail.getText().toString().equals(user.getEmail())){
                        user.setEmail(etUPEmail.getText().toString());
                    }
                } else
                    etUPEmail.selectAll();
            }
        });
        etUPDeliveryAddress.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!etUPDeliveryAddress.getText().toString().equals(user.getDeliveryAddress())){
                        user.setDeliveryAddress(etUPDeliveryAddress.getText().toString());
                    }
                } else
                    etUPDeliveryAddress.selectAll();
            }
        });
        etUPCard.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!etUPCard.getText().toString().equals(user.getCreditNumber())){
                        user.setCreditNumber(etUPCard.getText().toString());
                    }
                } else
                    etUPCard.selectAll();
            }
        });
        etUPExpiredDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!etUPExpiredDate.getText().toString().equals(user.getExpiredDate())){
                        user.setExpiredDate(etUPExpiredDate.getText().toString());
                    }
                }
            }
        });

    }

    public void updateCancelButtonClicked(View view) {
        finish();
    }


    public void updateButtonClicked(View view) {
        if(etUPFname.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "First Name is required", Toast.LENGTH_LONG).show();
        } else if (etUPLname.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Last Name is required", Toast.LENGTH_LONG).show();
        } else if(etUPUname.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "User Name is required", Toast.LENGTH_LONG).show();
        } else if(etUPPassword.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Password is required", Toast.LENGTH_LONG).show();
        } else if(etUPMobile.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Mobile Number is required", Toast.LENGTH_LONG).show();
        }else if(etUPDeliveryAddress.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Address is required", Toast.LENGTH_LONG).show();
        }else if(etUPCard.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Credit Card is required", Toast.LENGTH_LONG).show();
        }else if(etUPCard.getText().toString().length() < 16){
            Toast.makeText(this, "Please enter 16 credit card numbers", Toast.LENGTH_LONG).show();
        } else if(etUPExpiredDate.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Card Expired Date is required", Toast.LENGTH_LONG).show();
        }else {
            new UpdateUser().execute(user);
        }

    }

    private class UpdateUser extends AsyncTask<User,Void,Void> {

        @Override
        protected Void doInBackground(User... users) {
            updateResult = MainActivity.userDao.updateUser(users[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(updateResult != -1){
                Toast.makeText(getApplicationContext(),
                        "Your information has been updated",
                        Toast.LENGTH_LONG).show();
                finish();
            } else{
                Toast.makeText(getApplicationContext(),
                        "Please try again or contact us for further requirement",
                        Toast.LENGTH_LONG).show();}
        }
    }


    public void deleteButtonClicked(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete User");
        builder.setMessage("Are you want to delete account ?");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new DeleteUser().execute(user);}
            });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private class DeleteUser extends AsyncTask<User,Void,Void> {
        @Override
        protected Void doInBackground(User... users) {
            deleteResult = MainActivity.userDao.deleteUser(users[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(deleteResult == 1){
                Toast.makeText(getApplicationContext(),
                        "Delete Successfully!",
                        Toast.LENGTH_LONG).show();
                backToMain();
            } else{
                Toast.makeText(getApplicationContext(),
                        "Please try again or contact us for further requirement",
                        Toast.LENGTH_LONG).show();}
        }
    }

    private void backToMain(){
        finish();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
