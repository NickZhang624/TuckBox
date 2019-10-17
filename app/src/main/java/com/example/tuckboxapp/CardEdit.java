package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuckboxapp.DataModelPackage.Cards;
import com.example.tuckboxapp.DataModelPackage.User;

import java.util.Calendar;

public class CardEdit extends Menu {
    EditText etcard,etdate;
    DatePickerDialog.OnDateSetListener mDate;
    int updateResult,deleteResult;
    Cards cards;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_edit);
        cards = (Cards) getIntent().getSerializableExtra(AddCard.CREDITCARD_OBJECT);
        user = (User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);
        updateResult = -1;
        deleteResult = -1;
        etcard =findViewById(R.id.add_extra_card_number);
        etdate=findViewById(R.id.add_extra_card_date);
        etcard.setText(cards.getCardNumber());
        etdate.setText(cards.getExpiredDate());
        etdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        CardEdit.this,
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
                etdate.setText(date);
            }
        };

        setUIBehaviors();
    }

    private void setUIBehaviors(){
        etcard.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!etcard.getText().toString().equals(cards.getCardNumber())){
                        cards.setCardNumber(etcard.getText().toString());
                    }

                }else
                    etcard.selectAll();
            }
        });
        etdate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!etdate.getText().toString().equals(cards.getExpiredDate())){
                        cards.setExpiredDate(etdate.getText().toString());
                    }else
                        etdate.selectAll();

                }
            }
        });
    }


    public void updateButtonClicked(View view) {
        if(etcard.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Credit Card is required", Toast.LENGTH_LONG).show();
        }else if(etcard.getText().toString().length() < 16){
            Toast.makeText(this, "Please enter 16 credit card numbers", Toast.LENGTH_LONG).show();
        } else if (etdate.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Card Expired Date is required", Toast.LENGTH_LONG).show();
        } else {
            new UpdateCard().execute(cards);
        }
    }

    public void deleteButtonClicked(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete Credit Card");
        builder.setMessage("Are you want to delete credit card ?");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new DeleteCard().execute(cards);}
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private class DeleteCard extends AsyncTask<Cards,Void,Void> {
        @Override
        protected Void doInBackground(Cards... cards) {
            deleteResult = MainActivity.userDao.deletecard(cards[0]);
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

    public class UpdateCard extends AsyncTask<Cards,Void,Void> {

        @Override
        protected Void doInBackground(Cards... cards) {
            updateResult = MainActivity.userDao.updatecard(cards[0]);
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
                        "update card Successful!", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

    public void CancelButtonClicked(View view) {
        finish();
    }
}
