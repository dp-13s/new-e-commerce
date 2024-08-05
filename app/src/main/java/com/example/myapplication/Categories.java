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
import java.util.List;

public class Categories extends AppCompatActivity implements RecyclerViewInterface{

    TextView heading;
    categorymodel categoryModel;

    DatabaseReference chargersRef = FirebaseDatabase.getInstance().getReference().child("Chargers");
    DatabaseReference earphonesRef = FirebaseDatabase.getInstance().getReference().child("Earphones");

    String[] sub;

    AutoCompleteTextView search;
    ImageButton search_button;
    List<categorymodel> combinedList = new ArrayList<>();

    RecyclerView recyclerView;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_categories);

        search_button = findViewById(R.id.search_btn2);
        search = findViewById(R.id.search_bar2);


        sub = getResources().getStringArray(R.array.my_array);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.select_dialog_item,sub);
        search.setThreshold(1);
        search.setAdapter(adapter);

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = search.getText().toString();
                Intent intent1 = new Intent(Categories.this,Categories.class);
                intent1.putExtra("Data",data);
                startActivity(intent1);
            }
        });

        String data = getIntent().getStringExtra("Data");

        heading = findViewById(R.id.heading);
        String n = "Showing results for ";
        heading.setText(n.concat(data));

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<categorymodel> options =
                new FirebaseRecyclerOptions.Builder<categorymodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child(data), categorymodel.class)
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