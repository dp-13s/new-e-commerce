package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Categories extends AppCompatActivity implements RecyclerViewInterface{

    TextView heading;
    categorymodel categoryModel;

    private FirebaseRecyclerOptions<categorymodel> options;

    AutoCompleteTextView search;
    ImageButton search_button;

    String sub[]={"Clothing","Footwear","Shoes","Groceries","Beauty Products","Electronics","Home and Kitchen Appliances","Medicine","Men's Clothing","Women's Clothing","Kids Clothing","Men's Footwear","Women's Footwear","Kids Footwear","Phones","Laptops","Electronic Accessories","Makeup Products","Fruits","Vegetables","Dairy Products","Cereals","Grains","Pulses","Home Appliances","Decoration Items","Kitchen Appliances","Medicine"};

    RecyclerView recyclerView;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_categories);

        search_button = findViewById(R.id.search_btn2);
        search = findViewById(R.id.search_bar2);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.select_dialog_item,sub);
        search.setThreshold(1);
        search.setAdapter(adapter);

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = "Showing results for ";
                data = data.concat(search.getText().toString());
                Intent intent1 = new Intent(Categories.this,Categories.class);
                intent1.putExtra("Data",data);
                startActivity(intent1);
            }
        });

        String data = getIntent().getStringExtra("Data");
        heading = findViewById(R.id.heading);
        heading.setText(data);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        options =
                new FirebaseRecyclerOptions.Builder<categorymodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Chargers"), categorymodel.class)
                        .build();

        mainAdapter = new MainAdapter(this,options,this);
        recyclerView.setAdapter(mainAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }

    @Override
    public void onItemClick(int position) {


//        Intent intent = new Intent(Categories.this,ItemDetails.class);
//        intent.putExtra("name",options.getSnapshots().toString());
//        intent.putExtra("price",);
//        intent.putExtra("description",);
//        intent.putExtra("image",);
    }
}