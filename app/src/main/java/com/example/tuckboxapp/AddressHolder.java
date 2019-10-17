package com.example.tuckboxapp;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuckboxapp.DataModelPackage.Address;
import com.example.tuckboxapp.DataModelPackage.Cards;
import com.example.tuckboxapp.DataModelPackage.User;

public class AddressHolder extends RecyclerView.ViewHolder {
    User user;
    TextView textView;
    CardView cardView;
    Address address;
    public AddressHolder(@NonNull final View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_address_cardView);
        cardView = itemView.findViewById(R.id.address_cardView);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), AddressEdit.class);
                intent.putExtra(AddAddress.ADDRESS_OBJECT, address);
                itemView.getContext().startActivity(intent);
            }
        });

    }
}
