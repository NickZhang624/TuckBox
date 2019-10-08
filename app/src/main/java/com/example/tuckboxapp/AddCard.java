package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tuckboxapp.DataModelPackage.Cards;

public class AddCard extends Menu {
    long insertionResult;
    EditText etCard,etDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        insertionResult = -1;
        etCard = findViewById(R.id.new_card);
        etDate = findViewById(R.id.new_expired_date);
    }

    public void orderCancelButtonClicked(View view) {
        finish();
        Intent i = new Intent(this,UserListView.class);
        startActivity(i);
    }

    public void placeOrderNextButtonClicked(View view) {
        if(etCard.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Credit Card is required", Toast.LENGTH_LONG).show();
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
