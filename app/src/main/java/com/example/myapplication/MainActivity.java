package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
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

    ImageButton img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14;

    ImageButton image1,image2,image3,image4,image5,image6,image7;

    ImageButton imge1,imge2,imge3,imge4,imge5;

    String sub[]={"Clothing","Footwear","Shoes","Groceries","Beauty Products","Electronics","Home and Kitchen Appliances","Medicine","Men's Clothing","Women's Clothing","Kids Clothing","Men's Footwear","Women's Footwear","Kids Footwear","Phones","Laptops","Electronic Accessories","Makeup Products","Fruits","Vegetables","Dairy Products","Cereals","Grains","Pulses","Home Appliances","Decoration Items","Kitchen Appliances","Medicine"};

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
        img12=findViewById(R.id.b12);
        img13=findViewById(R.id.b13);
        img14=findViewById(R.id.b14);
        image1=findViewById(R.id.c1);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,Categories.class);
                String str = "Clothing";
                intent1.putExtra("Data",str);
                startActivity(intent1);
            }
        });

        image2=findViewById(R.id.c2);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,Categories.class);
                String str = "Footwear";
                intent1.putExtra("Data",str);
                startActivity(intent1);
            }
        });

        image3=findViewById(R.id.c3);
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,Categories.class);
                String str = "Groceries";
                intent1.putExtra("Data",str);
                startActivity(intent1);
            }
        });

        image4=findViewById(R.id.c4);
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,Categories.class);
                String str = "Beauty Products";
                intent1.putExtra("Data",str);
                startActivity(intent1);
            }
        });

        image5=findViewById(R.id.c5);
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,Categories.class);
                String str = "Electronics";
                intent1.putExtra("Data",str);
                startActivity(intent1);
            }
        });
        image6=findViewById(R.id.c6);
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,Categories.class);
                String str = "Home and Kitchen Appliances";
                intent1.putExtra("Data",str);
                startActivity(intent1);
            }
        });

        image7 =findViewById(R.id.cat7);
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,Categories.class);
                String str = "Medicine";
                intent1.putExtra("Data",str);
                startActivity(intent1);
            }
        });

        imge1=findViewById(R.id.d1);
        imge2=findViewById(R.id.d2);
        imge3=findViewById(R.id.d3);
        imge4=findViewById(R.id.d4);
        imge5=findViewById(R.id.d5);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.select_dialog_item,sub);
        search.setThreshold(1);
        search.setAdapter(adapter);

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = "Showing results for ";
                data = data.concat(search.getText().toString());
                Intent intent1 = new Intent(MainActivity.this,Categories.class);
                intent1.putExtra("Data",data);
                startActivity(intent1);
            }
        });

    }
}