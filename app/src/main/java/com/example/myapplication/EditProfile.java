package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditProfile extends AppCompatActivity {

    EditText username,email,phno,address;

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_profile);

        username = findViewById(R.id.edit_username);
        email = findViewById(R.id.edit_email);
        phno = findViewById(R.id.edit_phno);
        address = findViewById(R.id.edit_address);

        username.setText(getIntent().getStringExtra("name"));
        email.setText(getIntent().getStringExtra("email"));
        phno.setText(getIntent().getStringExtra("phno"));
        address.setText(getIntent().getStringExtra("add"));

        submit= findViewById(R.id.update_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditProfile.this,Profile.class);
                intent.putExtra("name",username.getText().toString());
                intent.putExtra("email",email.getText().toString());
                intent.putExtra("phno",phno.getText().toString());
                intent.putExtra("add",address.getText().toString());

                Toast.makeText(EditProfile.this, "Profile Updated Successfully", Toast.LENGTH_SHORT).show();

                startActivity(intent);
                finish();
            }
        });

    }
}