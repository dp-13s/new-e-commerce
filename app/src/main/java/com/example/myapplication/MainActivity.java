package com.example.myapplication;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView search;
    TextView address;
    ImageButton img1;
    ImageButton img2;
    ImageButton img3;
    ImageButton img4;
    ImageButton img5;
    ImageButton img6;
    ImageButton img7;
    ImageButton img8;
    ImageButton img9;
    ImageButton img10;
    ImageButton img11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        search = findViewById(R.id.search_bar);
        address = findViewById(R.id.textView3);
        img1=findViewById(R.id.b1);
        img2=findViewById(R.id.b2);
        img3=findViewById(R.id.b3);
        img4=findViewById(R.id.b4);
        img5=findViewById(R.id.b5);
        img6=findViewById(R.id.b6);
        img7=findViewById(R.id.b7);
        img8=findViewById(R.id.b8);
        img9=findViewById(R.id.b9);
        img10=findViewById(R.id.b10);
        img11=findViewById(R.id.b11);



    }
}