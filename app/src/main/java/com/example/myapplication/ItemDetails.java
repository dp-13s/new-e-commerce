package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ItemDetails extends AppCompatActivity {

    ImageView image;

    TextView title,description,quantity;

    ImageButton remove,add;

    Button order ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_details);

        image = findViewById(R.id.item_image);
        title = findViewById(R.id.item_name);
        description = findViewById(R.id.item_description);
        quantity = findViewById(R.id.quantity);
        remove = findViewById(R.id.subtract);
        add = findViewById(R.id.add);
        order = findViewById(R.id.order_button);


        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int val = Integer.parseInt(quantity.getText().toString());
                if(val>0){
                    val = val - 1;
                    quantity.setText(String.valueOf(val));
                }
                else {
                    Toast.makeText(ItemDetails.this, "Unable to remove any more item", Toast.LENGTH_SHORT).show();
                }
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