package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OrderSummary extends AppCompatActivity {

    TextView item_name,item_price,item_quantity,total_amount,delivery;
    Button placeorder;
    RadioButton payment_method;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_summary);

        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        String quantity = getIntent().getStringExtra("quantity");

        price.replaceAll(" ","");
        price = price.substring(1);


        payment_method = findViewById(R.id.payment_method);
        item_name = findViewById(R.id.summary_name);
        item_price = findViewById(R.id.summary_price);
        item_quantity = findViewById(R.id.summary_quantity);
        total_amount = findViewById(R.id.summary_total_amount);

        String total = Integer.toString(Integer.parseInt(price)*Integer.parseInt(quantity));

        item_name.setText(name);
        item_quantity.setText(quantity);
        item_price.setText(item_price.getText().toString().concat(price));
        total_amount.setText(total_amount.getText().toString().concat(total));



        placeorder = findViewById(R.id.place_order);
        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if the payment_method RadioButton is checked
                if (payment_method.isChecked()) {
                    // Show the alert dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(OrderSummary.this);
                    builder.setTitle("Confirm Order");
                    builder.setMessage("Are you sure you want to place the order?");

                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Start the FinalOrder activity
                            Intent intent = new Intent(OrderSummary.this, FinalOrder.class);
                            startActivity(intent);
                            finish(); // Close the current activity
                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss(); // Close the dialog if 'No' is clicked
                        }
                    });

                    builder.show();
                } else {
                    // Show a toast if the payment_method RadioButton is not checked
                    Toast.makeText(OrderSummary.this, "Please select a payment method before proceeding", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delivery = findViewById(R.id.delivery);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 3);

        // Format the delivery date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String deliveryDate = dateFormat.format(calendar.getTime());

        // Display the delivery date in the TextView
        delivery.setText(delivery.getText().toString().concat(deliveryDate));

    }
}