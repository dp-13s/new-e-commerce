package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class ItemDetails extends AppCompatActivity {

    ImageView image;

    TextView title,descriptions,quantity,prices;

    ImageButton remove,add;

    Button order ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_details);


        image = findViewById(R.id.item_image);
        prices=findViewById(R.id.item_price);
        title = findViewById(R.id.item_name);
        descriptions = findViewById(R.id.item_description);
        quantity = findViewById(R.id.quantity);
        remove = findViewById(R.id.subtract);
        add = findViewById(R.id.add);
        order = findViewById(R.id.order_button);

        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        String description = getIntent().getStringExtra("description");
        String image_url = getIntent().getStringExtra("image");

        title.setText(name);
        prices.setText(price);
        descriptions.setText(description);
        Glide.with(this).load(image_url).into(image);


        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int val = Integer.parseInt(quantity.getText().toString());
                if(val>1){
                    val = val - 1;
                    quantity.setText(String.valueOf(val));
                }
                else {
                    Toast.makeText(ItemDetails.this, "Unable to remove any more item", Toast.LENGTH_SHORT).show();
                }
            }
        });


        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemDetails.this, OrderSummary.class);
                intent.putExtra("name",title.getText().toString());
                intent.putExtra("price",prices.getText().toString());
                intent.putExtra("quantity",quantity.getText().toString());
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int val = Integer.parseInt(quantity.getText().toString());
                if(val<20){
                    val = val + 1;
                    quantity.setText(String.valueOf(val));
                }
                else {
                    Toast.makeText(ItemDetails.this, "Unable to add any more item", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}