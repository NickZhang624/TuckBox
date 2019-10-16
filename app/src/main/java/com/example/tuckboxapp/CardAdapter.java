package com.example.tuckboxapp;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuckboxapp.DataModelPackage.Cards;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter <CardHolder>{
    List<Cards> data = null;

    public CardAdapter(){
        new RecyclerViewApdaterData().execute();
    }

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.credit_card_cardview, parent,false);
        return new CardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        holder.cards = data.get(position);
        holder.textView.setText(holder.cards.getCardNumber());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class RecyclerViewApdaterData extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            data =  MainActivity.userDao.readCreditCardsByUserID(AppServices.user.getID());
            return null;
        }
    }
}
