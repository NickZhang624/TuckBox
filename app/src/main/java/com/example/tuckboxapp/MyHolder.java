package com.example.tuckboxapp;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuckboxapp.DataModelPackage.User;

public class MyHolder extends RecyclerView.ViewHolder {
    User user;
    TextView etFName, etLName, etUName, etPassword, etMobile, etEmail, etAddress, etCardNumber,
            etExpiredDate;
    Spinner spTitle;

    CardView cardView;
    ImageView imageView;

    public MyHolder(@NonNull final View itemView){
        super(itemView);
//        spTitle = itemView.findViewById(R.id.spinner_up_title);
        imageView = itemView.findViewById(R.id.user_item_card_list_image);
        etFName = itemView.findViewById(R.id.user_item_card_first_name);
//        etLName = itemView.findViewById(R.id.edit_up_last_name);
        etUName = itemView.findViewById(R.id.user_item_card_list_uname);
//        etPassword = itemView.findViewById(R.id.edit_up_password);
        etMobile = itemView.findViewById(R.id.user_item_card_list_mobile);
//        etEmail= itemView.findViewById(R.id.edit_up_email);
//        etAddress=itemView.findViewById(R.id.edit_up_adress);
//        etCardNumber= itemView.findViewById(R.id.edit_up_credit_card);
//        etExpiredDate= itemView.findViewById(R.id.edit_up_expired_date);

        cardView = itemView.findViewById(R.id.user_item_card);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        itemView.getContext(),
                        "Card has been clicked",
                        Toast.LENGTH_LONG
                ).show();
                Intent intent = new Intent(itemView.getContext(), UserUpdateInfo.class);
                intent.putExtra(MainActivity.USER_OBJECT, user);
                itemView.getContext().startActivity(intent);
            }
        });
    }

}
