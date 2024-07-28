package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView search;
    ImageButton search_button;

    TextView address;

    ImageButton img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11;

    ImageButton image1,image2,image3,image4,image5,image6,image7;

    ImageButton imge1,imge2,imge3,imge4,imge5;

    String sub[]={"Data Structure","Computer Architecture","DBMS","Operating System","Computer Network"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        search_button = findViewById(R.id.search_btn);
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


        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.select_dialog_item,sub);
        search.setThreshold(1);
        search.setAdapter(adapter);

    }
}