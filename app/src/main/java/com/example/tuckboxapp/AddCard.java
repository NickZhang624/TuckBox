package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuckboxapp.DataModelPackage.Cards;

import java.util.Calendar;

public class AddCard extends Menu {
    long insertionResult;
    EditText etCard;
    TextView etDate;
    DatePickerDialog.OnDateSetListener mDate;
    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        insertionResult = -1;
        etCard = findViewById(R.id.new_card);
        etDate = findViewById(R.id.new_expired_date);

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        AddCard.this,
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
                etDate.setText(date);
            }
        };
    }

    public void orderCancelButtonClicked(View view) {
        finish();
        Intent i = new Intent(this,UserListView.class);
        startActivity(i);
    }

    public void placeOrderNextButtonClicked(View view) {
        if(etCard.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Credit Card is required", Toast.LENGTH_LONG).show();
        }else if(etCard.getText().toString().length() < 16){
            Toast.makeText(this, "Please enter 16 credit card numbers", Toast.LENGTH_LONG).show();
        } else if (etDate.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Card Expired Date is required", Toast.LENGTH_LONG).show();
        } else {
            Cards cards = new Cards();
            cards.setCardNumber(etCard.getText().toString());
            cards.setExpiredDate(etDate.getText().toString());

            InsertCards insertCards = new InsertCards();
            insertCards.execute(cards);
        }
    }

    public class InsertCards extends AsyncTask<Cards,Void,Void>{

        @Override
        protected Void doInBackground(Cards... cards) {
            insertionResult = MainActivity.userDao.insertcard(cards[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(insertionResult == -1){
                Toast.makeText(getApplicationContext(),
                        "Error: add cards failed, please try it again.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Add card Successful!", Toast.LENGTH_LONG).show();
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
