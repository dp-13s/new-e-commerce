package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Profile extends AppCompatActivity {

    TextView name,phno,add,email;

    Button edit,seller,customer_support ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);



        name = findViewById(R.id.customer_name);
        phno = findViewById(R.id.customer_phno);
        add = findViewById(R.id.customer_address);
        email = findViewById(R.id.customer_email);


        name.setText(getIntent().getStringExtra("name"));
        phno.setText(getIntent().getStringExtra("phno"));
        add.setText(getIntent().getStringExtra("add"));
        email.setText(getIntent().getStringExtra("email"));

        edit = findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this,EditProfile.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("phno",phno.getText().toString());
                intent.putExtra("add",add.getText().toString());
                intent.putExtra("email",email.getText().toString());
                startActivity(intent);
            }
        });


        seller =findViewById(R.id.seller);
        seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Profile.this, "This feature will be added soon. Please cooperate with us :)", Toast.LENGTH_SHORT).show();
            }
        });

        customer_support = findViewById(R.id.customer_support);
        customer_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Profile.this, "This feature will be added soon. Please cooperate with us :)", Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton home = findViewById(R.id.home_btn);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this,MainActivity.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("phno",phno.getText().toString());
                intent.putExtra("add",add.getText().toString());
                intent.putExtra("email",email.getText().toString());
                startActivity(intent);
                finish();
            }
        });


    }
}