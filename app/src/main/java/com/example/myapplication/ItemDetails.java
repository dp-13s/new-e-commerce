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

    RadioButton checkbox;
    ImageButton remove,add;

    Button order ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_details);

        checkbox = findViewById(R.id.checkbox);

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
                // Check if the radio button is checked
                if (checkbox.isChecked()) {
                    // If checked, show the alert dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setTitle("Confirm Order");
                    builder.setMessage("Are you sure you want to place the order?");

                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                            int quan = Integer.parseInt(quantity.getText().toString());
//                            int pr = Integer.parseInt(prices.getText().toString());
//                            int fin = quan * pr;

                            Intent intent = new Intent(ItemDetails.this, FinalOrder.class);
                            startActivity(intent);
                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    builder.show();
                } else {
                    // If not checked, show a toast message
                    Toast.makeText(view.getContext(), "Please select payment options before proceeding", Toast.LENGTH_SHORT).show();
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