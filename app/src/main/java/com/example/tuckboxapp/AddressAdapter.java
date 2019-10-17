package com.example.tuckboxapp;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuckboxapp.DataModelPackage.Address;
import com.example.tuckboxapp.DataModelPackage.Cards;

import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter <AddressHolder> {
    List<Address> data = null;
    public AddressAdapter(){
        new RecyclerViewApdaterData().execute();
    }
    @NonNull
    @Override
    public AddressHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.address_cardview, parent,false);
        return new AddressHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressHolder holder, int position) {
        holder.address = data.get(position);
        holder.textView.setText(holder.address.getAddress());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class RecyclerViewApdaterData extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            data =  MainActivity.userDao.readAddressByUserID(AppServices.user.getID());
            return null;
        }
    }
}
