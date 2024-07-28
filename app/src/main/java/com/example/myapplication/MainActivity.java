package com.example.myapplication;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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

    ImageButton image1;
    ImageButton image2;
    ImageButton image3;
    ImageButton image4;
    ImageButton image5;
    ImageButton image6;
    ImageButton image7;

    ImageButton imge1;
    ImageButton imge2;
    ImageButton imge3;
    ImageButton imge4;
    ImageButton imge5;

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
        image1=findViewById(R.id.c1);
        image2=findViewById(R.id.c2);
        image3=findViewById(R.id.c3);
        image4=findViewById(R.id.c4);
        image5=findViewById(R.id.c5);
        image6=findViewById(R.id.c6);

        image7 =findViewById(R.id.cat7);

        imge1=findViewById(R.id.d1);
        imge2=findViewById(R.id.d2);
        imge3=findViewById(R.id.d3);
        imge4=findViewById(R.id.d4);
        imge5=findViewById(R.id.d5);

    }
}