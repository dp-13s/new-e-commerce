package com.example.myapplication;

import static com.example.myapplication.R.id.Home;
import static com.example.myapplication.R.id.Profile;
import static com.example.myapplication.R.id.Menu;

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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView search;
    ImageButton search_button;

    TextView address;

    ImageButton img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11;

    ImageButton image1,image2,image3,image4,image5,image6,image7;

    ImageButton imge1,imge2,imge3,imge4,imge5;

    ActivityMainBinding binding;


    String sub[]={"Data Structure","Computer Architecture","DBMS","Operating System","Computer Network"};

    @SuppressLint({"MissingInflatedId","NonConstantResourceId"})
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
        image7=findViewById(R.id.c7);

        imge1=findViewById(R.id.d1);
        imge2=findViewById(R.id.d2);
        imge3=findViewById(R.id.d3);
        imge4=findViewById(R.id.d4);
        imge5=findViewById(R.id.d5);



        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Search Button Pressed", Toast.LENGTH_SHORT).show();

            }


        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Category1.class);
                startActivity(intent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Category2.class);
                startActivity(intent1);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, Category3.class);
                startActivity(intent2);
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, Category4.class);
                startActivity(intent3);
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity.this, Category5.class);
                startActivity(intent4);
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(MainActivity.this, Category6.class);
                startActivity(intent5);
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(MainActivity.this, Category7.class);
                startActivity(intent6);
            }
        });

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.Home:
                    replaceFragment(new HomeFragment());
                   break;


                   case Profile:
                       replaceFragment(new ProfileFragment());
                       break;


                case Menu:
                    replaceFragment(new MenuFragment());
                    break;
            }

            return true;
        });



        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.select_dialog_item,sub);
        search.setThreshold(1);
        search.setAdapter(adapter);


    }
    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_Layout,fragment);
        fragmentTransaction.commit();
    }
}