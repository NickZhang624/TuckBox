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
    TextView etName, etTitle;

    CardView cardView;
    ImageView imageView;

    public MyHolder(@NonNull final View itemView){
        super(itemView);
        etTitle = itemView.findViewById(R.id.user_item_card_title);
        imageView = itemView.findViewById(R.id.user_item_card_list_image);
        etName = itemView.findViewById(R.id.user_item_card_name);
        cardView = itemView.findViewById(R.id.user_item_card);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), UserUpdateInfo.class);
                intent.putExtra(MainActivity.USER_OBJECT, user);
                itemView.getContext().startActivity(intent);
            }
        });
    }

}
