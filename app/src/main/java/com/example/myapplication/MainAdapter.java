package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.myViewHolder> {

    private Context context;
    private List<categorymodel> categoryList;  // List of data from multiple nodes
    private final RecyclerViewInterface recyclerViewInterface;

    // Constructor that accepts a list of data and context
    public MainAdapter(Context context, List<categorymodel> categoryList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.categoryList = categoryList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        categorymodel model = categoryList.get(position);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ItemDetails.class);
            intent.putExtra("name", model.getName());
            intent.putExtra("price", model.getPrice());
            intent.putExtra("description", model.getDescription());
            intent.putExtra("image", model.getImage());
            context.startActivity(intent);
        });

        holder.name.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.desc.setText(model.getDescription());

        Glide.with(holder.image.getContext())
                .load(model.getImage())
                .placeholder(R.drawable.ic_baseline_shopping_cart_24)
                .centerCrop()
                .error(R.drawable.cloud_download)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();  // Returns the size of the combined data list
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, price, desc;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.product_image);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);
            desc = itemView.findViewById(R.id.product_des);

            itemView.setOnClickListener(view -> {
                if (recyclerViewInterface != null) {
                    int position = getBindingAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(position);
                    }
                }
            });
        }
    }
}
