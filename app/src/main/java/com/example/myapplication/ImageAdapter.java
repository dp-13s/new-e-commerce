package com.example.myapplication;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class ImageAdapter {

    Context context;

    ArrayList<Image> arrayList;

    public ImageAdapter(Context context,ArrayList<Image> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


        ImageView imageView;
        TextView name,price;

        public RecyclerView.ViewHolder
    }
}
