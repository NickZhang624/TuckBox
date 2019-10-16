package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
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

public class CardEdit extends AppCompatActivity {
    EditText editText,editText1;
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
        editText =findViewById(R.id.add_extra_card_number);
        editText1=findViewById(R.id.add_extra_card_date);
        editText.setText(cards.getCardNumber());
        editText1.setText(cards.getExpiredDate());
        editText1.setOnClickListener(new View.OnClickListener() {
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
                editText1.setText(date);
            }
        };

        setUIBehaviors();
    }

    private void setUIBehaviors(){
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!editText.getText().toString().equals(cards.getCardNumber())){
                        cards.setCardNumber(editText.getText().toString());
                    }

                }else
                    editText.selectAll();
            }
        });
        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(!editText1.getText().toString().equals(cards.getExpiredDate())){
                        cards.setExpiredDate(editText1.getText().toString());
                    }else
                        editText1.selectAll();

                }
            }
        });
    }


    public void updateButtonClicked(View view) {
        if(editText.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Credit Card is required", Toast.LENGTH_LONG).show();
        }else if(editText.getText().toString().length() < 16){
            Toast.makeText(this, "Please enter 16 credit card numbers", Toast.LENGTH_LONG).show();
        } else if (editText1.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Card Expired Date is required", Toast.LENGTH_LONG).show();
        } else {
            new UpdateCard().execute(cards);
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
