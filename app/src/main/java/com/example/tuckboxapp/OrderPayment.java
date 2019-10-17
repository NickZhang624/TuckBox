package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuckboxapp.DataModelPackage.Cards;
import com.example.tuckboxapp.DataModelPackage.User;

import java.util.Calendar;

import static com.example.tuckboxapp.OrderAddress.EXTRA_ADDRESS;
import static com.example.tuckboxapp.PlaceOrder.EXTRA_NOTE;
import static com.example.tuckboxapp.PlaceOrder.EXTRA_ORDERED;
import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_REGION;
import static com.example.tuckboxapp.RegionAndDeliveryTime.EXTRA_TIME;

public class OrderPayment extends Menu {

    long insertionResult;
    TextView tvCard,tvdate,tvNewCard,tvNewCardDate,tvAsking;
    EditText etCard;
    Button buttonCancel,buttonNext,buttonAddaNewCard;
    LinearLayout linearLayout;
    ConstraintLayout constraintLayout;
    CheckBox cb,cb1,cb3;
    Spinner spinner;
    DatePickerDialog.OnDateSetListener mDate;
    private static final String TAG = "TAG";
    public static final String EXTRA_CARD ="EXTRA_CARD";
    public static final String EXTRA_CARDDATE ="EXTRA_CARDDATE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_payment);
        user =(User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);

        tvCard =findViewById(R.id.order_credit_card);
        cb=findViewById(R.id.checkBox);
        cb.setChecked(true);

        //spinner = findViewById(R.id.spinner_card);
        //cb3=findViewById(R.id.checkBox3);

        constraintLayout =findViewById(R.id.new_payment_cons);
        tvNewCard =findViewById(R.id.new_credit_card);
        tvNewCardDate=findViewById(R.id.new_card_date);
        cb1=findViewById(R.id.checkBox1);

        tvAsking=findViewById(R.id.asking);
        buttonAddaNewCard=findViewById(R.id.add_a_new_card);
        linearLayout =findViewById(R.id.payment_linear);

        etCard =findViewById(R.id.new_card);
        tvdate = findViewById(R.id.new_expired_date);

        buttonCancel = findViewById(R.id.btn_order_cancel);
        buttonNext =findViewById(R.id.btn_next_order);

        tvCard.setText(user.getCreditNumber());
        tvdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        OrderPayment.this,
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
                tvdate.setText(date);
            }
        };
    }

    public void orderCancelButtonClicked(View view) {
        finish();
    }

    public void placeOrderNextButtonClicked(View view) {
        String card = tvCard.getText().toString();
        String card1 = tvNewCard.getText().toString();
        String date1 = tvNewCardDate.getText().toString();

        Intent a = getIntent();
        String region =a.getStringExtra(EXTRA_REGION);
        String time = a.getStringExtra(EXTRA_TIME);
        String note = a.getStringExtra(EXTRA_NOTE);
        String order = a.getStringExtra(EXTRA_ORDERED);
        String address = a.getStringExtra(EXTRA_ADDRESS);

        if(cb.isChecked() && !cb1.isChecked()){
            Intent i = new Intent(this,Confirmation.class);
            i.putExtra(EXTRA_REGION,region);
            i.putExtra(EXTRA_TIME,time);
            i.putExtra(EXTRA_NOTE,note);
            i.putExtra(EXTRA_ORDERED,order);
            i.putExtra(EXTRA_ADDRESS,address);
            i.putExtra(EXTRA_CARD,card);
            i.putExtra(MainActivity.USER_OBJECT,user);
            startActivity(i);
        }else if(cb1.isChecked() && !cb.isChecked()){
            Intent i = new Intent(this,Confirmation.class);
            i.putExtra(EXTRA_REGION,region);
            i.putExtra(EXTRA_TIME,time);
            i.putExtra(EXTRA_NOTE,note);
            i.putExtra(EXTRA_ORDERED,order);
            i.putExtra(EXTRA_ADDRESS,address);
            i.putExtra(EXTRA_CARD,card1);
            i.putExtra(EXTRA_CARDDATE,date1);
            i.putExtra(MainActivity.USER_OBJECT,user);
            startActivity(i);
        }else if(cb.isChecked() && cb1.isChecked()){
            Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
        }else if( !cb.isChecked() && !cb1.isChecked()){
            Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
        }
    }

    public void addANewCardButtonClicked(View view) {
        buttonAddaNewCard.setVisibility(View.GONE);
        linearLayout.setVisibility(View.VISIBLE);
    }

    public void cancelPaymentButtonClicked(View view) {
        etCard.setText(null);
        tvdate.setText(null);
        linearLayout.setVisibility(View.GONE);
        buttonAddaNewCard.setVisibility(View.VISIBLE);
    }

    public void savePaymentButtonClicked(View view) {

        if(etCard.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Credit Card is required", Toast.LENGTH_LONG).show();
        }else if(etCard.getText().toString().length() < 16){
            Toast.makeText(this, "Please enter 16 credit card numbers", Toast.LENGTH_LONG).show();
        } else if (tvdate.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Card Expired Date is required", Toast.LENGTH_LONG).show();
        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Remember Card");
            builder.setMessage("Are you want to save this card into your account for further using ?");

            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Cards cards = new Cards();
                    cards.setCardNumber(etCard.getText().toString());
                    cards.setExpiredDate(tvdate.getText().toString());
                    cards.setID(user.getID());
                    cb1.setChecked(true);
                    tvAsking.setVisibility(View.GONE);
                    cb.setChecked(false);

                    InsertCards insertCards = new InsertCards();
                    insertCards.execute(cards);

                }
            });

            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    getInfo();
                    Toast.makeText(getApplicationContext(),
                            "Not remember card into your profile, ONLY use this time", Toast.LENGTH_LONG).show();

                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }


    public class InsertCards extends AsyncTask<Cards,Void,Void> {

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
                getInfo();
            }
        }
    }

    public void getInfo(){
        String card = etCard.getText().toString();
        linearLayout.setVisibility(View.GONE);
        constraintLayout.setVisibility(View.VISIBLE);
        tvNewCard.setText(card);
        cb1.setChecked(true);
        tvAsking.setVisibility(View.GONE);
        cb.setChecked(false);
    }
}
