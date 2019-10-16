package com.example.tuckboxapp;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuckboxapp.DataModelPackage.Cards;
import com.example.tuckboxapp.DataModelPackage.User;
import com.example.tuckboxapp.DataModelPackage.UserDatabase;

public class CardHolder extends RecyclerView.ViewHolder {
    User user;
    TextView textView;
    CardView cardView;
    Cards cards;
    public  static UserDatabase myDao;
    public CardHolder(@NonNull final View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.credit_card_number_cardView);
        cardView = itemView.findViewById(R.id.credit_card_cardView);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), CardEdit.class);
                intent.putExtra(AddCard.CREDITCARD_OBJECT, cards);
                itemView.getContext().startActivity(intent);
            }
        });

    }
}
