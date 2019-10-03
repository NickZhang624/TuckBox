package com.example.tuckboxapp;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuckboxapp.DataModelPackage.User;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    List<User> data =null;

    public MyAdapter(){
        new LoadUserInfo().execute();
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.user_cardview, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.user =data.get(position);
//        holder.etLName.setText(holder.user.getLastName());
        holder.etFName.setText(holder.user.getFirstName());
        holder.etUName.setText(holder.user.getUserName());
//        holder.etPassword.setText(holder.user.getPassword());
        holder.etMobile.setText(holder.user.getMobileNumber());
//        holder.etEmail.setText(holder.user.getEmail());
//        holder.etAddress.setText(holder.user.getDeliveryAddress());
//        holder.etCardNumber.setText(holder.user.getCreditNumber());
//        holder.etExpiredDate.setText(holder.user.getExpiredDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class LoadUserInfo extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            data = MainActivity.userDao.readAllUers();
            return null;
        }
    }
}
