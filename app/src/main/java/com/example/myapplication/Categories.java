package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Categories extends AppCompatActivity implements RecyclerViewInterface{

    TextView heading;
    categorymodel categoryModel;

    String[] sub;
    List<categorymodel> categoryList;

    AutoCompleteTextView search;
    ImageButton search_button;
    List<categorymodel> combinedList = new ArrayList<>();

    RecyclerView recyclerView;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_categories);

        search_button = findViewById(R.id.search_btn2);
        search = findViewById(R.id.search_bar2);


        sub = getResources().getStringArray(R.array.my_array);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.select_dialog_item,sub);
        search.setThreshold(1);
        search.setAdapter(adapter);

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = search.getText().toString();
                Intent intent1 = new Intent(Categories.this,Categories.class);
                intent1.putExtra("Data",data);
                startActivity(intent1);
            }
        });

        String data = getIntent().getStringExtra("Data");
        heading = findViewById(R.id.heading);
        String n = "Showing results for ";
        heading.setText(n.concat(data));

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        switch (data){


            case "Home and Kitchen Appliances":{

                DatabaseReference node1Ref = FirebaseDatabase.getInstance().getReference("Bed");
                DatabaseReference node2Ref = FirebaseDatabase.getInstance().getReference("Sofa");
                DatabaseReference node3Ref = FirebaseDatabase.getInstance().getReference("Air Fryer");
                DatabaseReference node4Ref = FirebaseDatabase.getInstance().getReference("Cooker");
                DatabaseReference node5Ref = FirebaseDatabase.getInstance().getReference("Gas Stove");
                DatabaseReference node6Ref = FirebaseDatabase.getInstance().getReference("Microwave Oven");
                DatabaseReference node7Ref = FirebaseDatabase.getInstance().getReference("Pan");
                DatabaseReference node8Ref = FirebaseDatabase.getInstance().getReference("Refridgerator");
                DatabaseReference node9Ref = FirebaseDatabase.getInstance().getReference("Spatula");
                DatabaseReference node10Ref = FirebaseDatabase.getInstance().getReference("Television");
                DatabaseReference node11Ref = FirebaseDatabase.getInstance().getReference("Washing Machine");

                // Combined list to hold data from all nodes
                List<categorymodel> combinedList = new ArrayList<>();

                // Counter to track completion
                final int[] nodesFetched = {0};
                final int totalNodes = 11;

                // Function to check if all nodes have been fetched
                ValueEventListener checkCompletionListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        nodesFetched[0]++;

                        // Check if all nodes have been processed
                        if (nodesFetched[0] == totalNodes) {
                            // Set up the adapter with the combined data
                            MainAdapter mainAdapter = new MainAdapter(Categories.this, combinedList, Categories.this);
                            recyclerView.setAdapter(mainAdapter);
                            mainAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                        Toast.makeText(Categories.this, "Error fetching data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                };

                // Fetch data from each node
                node1Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node2Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node3Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node4Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node5Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node6Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node7Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node8Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node9Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node10Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node1Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node11Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                break;

            }

            case "Electronic Accessories":{

                DatabaseReference node1Ref = FirebaseDatabase.getInstance().getReference("Chargers");
                DatabaseReference node2Ref = FirebaseDatabase.getInstance().getReference("Earphones");
                DatabaseReference node3Ref = FirebaseDatabase.getInstance().getReference("Headset");


                List<categorymodel> combinedList = new ArrayList<>();

                // Counter to track completion
                final int[] nodesFetched = {0};
                final int totalNodes = 3;

                // Function to check if all nodes have been fetched
                ValueEventListener checkCompletionListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        nodesFetched[0]++;

                        // Check if all nodes have been processed
                        if (nodesFetched[0] == totalNodes) {
                            // Set up the adapter with the combined data
                            MainAdapter mainAdapter = new MainAdapter(Categories.this, combinedList, Categories.this);
                            recyclerView.setAdapter(mainAdapter);
                            mainAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                        Toast.makeText(Categories.this, "Error fetching data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                };

                // Fetch data from each node
                node1Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node2Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node3Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });
                break;
            }

            case "Medicine":{

                DatabaseReference node1Ref = FirebaseDatabase.getInstance().getReference("Medical Pills");
                DatabaseReference node2Ref = FirebaseDatabase.getInstance().getReference("Medical Solutions");
                DatabaseReference node3Ref = FirebaseDatabase.getInstance().getReference("Bandages");


                List<categorymodel> combinedList = new ArrayList<>();

                // Counter to track completion
                final int[] nodesFetched = {0};
                final int totalNodes = 3;

                // Function to check if all nodes have been fetched
                ValueEventListener checkCompletionListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        nodesFetched[0]++;

                        // Check if all nodes have been processed
                        if (nodesFetched[0] == totalNodes) {
                            // Set up the adapter with the combined data
                            MainAdapter mainAdapter = new MainAdapter(Categories.this, combinedList, Categories.this);
                            recyclerView.setAdapter(mainAdapter);
                            mainAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                        Toast.makeText(Categories.this, "Error fetching data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                };

                // Fetch data from each node
                node1Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node2Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node3Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });
                break;
            }

            case "Books":{

                DatabaseReference node1Ref = FirebaseDatabase.getInstance().getReference("Kids Books");
                DatabaseReference node2Ref = FirebaseDatabase.getInstance().getReference("Romance Books");
                DatabaseReference node3Ref = FirebaseDatabase.getInstance().getReference("Science Fiction Books");


                List<categorymodel> combinedList = new ArrayList<>();

                // Counter to track completion
                final int[] nodesFetched = {0};
                final int totalNodes = 2;

                // Function to check if all nodes have been fetched
                ValueEventListener checkCompletionListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        nodesFetched[0]++;

                        // Check if all nodes have been processed
                        if (nodesFetched[0] == totalNodes) {
                            // Set up the adapter with the combined data
                            MainAdapter mainAdapter = new MainAdapter(Categories.this, combinedList, Categories.this);
                            recyclerView.setAdapter(mainAdapter);
                            mainAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                        Toast.makeText(Categories.this, "Error fetching data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                };

                // Fetch data from each node
                node1Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node3Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node2Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });
                break;
            }

            case "Electronics":{

                DatabaseReference node1Ref = FirebaseDatabase.getInstance().getReference("Chargers");
                DatabaseReference node2Ref = FirebaseDatabase.getInstance().getReference("Earphones");
                DatabaseReference node3Ref = FirebaseDatabase.getInstance().getReference("Headset");
                DatabaseReference node4Ref = FirebaseDatabase.getInstance().getReference("Laptop");
                DatabaseReference node5Ref = FirebaseDatabase.getInstance().getReference("Phones");
                DatabaseReference node6Ref = FirebaseDatabase.getInstance().getReference("Tabs");
                DatabaseReference node7Ref = FirebaseDatabase.getInstance().getReference("Air Fryer");
                DatabaseReference node8Ref = FirebaseDatabase.getInstance().getReference("Microwave Oven");
                DatabaseReference node9Ref = FirebaseDatabase.getInstance().getReference("Refridgerator");
                DatabaseReference node10Ref = FirebaseDatabase.getInstance().getReference("Television");
                DatabaseReference node11Ref = FirebaseDatabase.getInstance().getReference("Washing Machine");

                // Combined list to hold data from all nodes
                List<categorymodel> combinedList = new ArrayList<>();

                // Counter to track completion
                final int[] nodesFetched = {0};
                final int totalNodes = 11;

                // Function to check if all nodes have been fetched
                ValueEventListener checkCompletionListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        nodesFetched[0]++;

                        // Check if all nodes have been processed
                        if (nodesFetched[0] == totalNodes) {
                            // Set up the adapter with the combined data
                            MainAdapter mainAdapter = new MainAdapter(Categories.this, combinedList, Categories.this);
                            recyclerView.setAdapter(mainAdapter);
                            mainAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                        Toast.makeText(Categories.this, "Error fetching data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                };

                // Fetch data from each node
                node1Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node7Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node8Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node9Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node10Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node11Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node2Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node3Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node4Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node5Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node6Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                break;

            }

            case "Beauty Products":{

                DatabaseReference node1Ref = FirebaseDatabase.getInstance().getReference("Brush");
                DatabaseReference node2Ref = FirebaseDatabase.getInstance().getReference("Compact");
                DatabaseReference node3Ref = FirebaseDatabase.getInstance().getReference("Consealer");
                DatabaseReference node4Ref = FirebaseDatabase.getInstance().getReference("Contour");
                DatabaseReference node5Ref = FirebaseDatabase.getInstance().getReference("Eye Shadow");
                DatabaseReference node6Ref = FirebaseDatabase.getInstance().getReference("Eyeliner");
                DatabaseReference node7Ref = FirebaseDatabase.getInstance().getReference("Foundation");
                DatabaseReference node8Ref = FirebaseDatabase.getInstance().getReference("Highlighter");
                DatabaseReference node9Ref = FirebaseDatabase.getInstance().getReference("Lipstick");
                DatabaseReference node10Ref = FirebaseDatabase.getInstance().getReference("Maskara");

                // Combined list to hold data from all nodes
                List<categorymodel> combinedList = new ArrayList<>();

                // Counter to track completion
                final int[] nodesFetched = {0};
                final int totalNodes = 10;

                // Function to check if all nodes have been fetched
                ValueEventListener checkCompletionListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        nodesFetched[0]++;

                        // Check if all nodes have been processed
                        if (nodesFetched[0] == totalNodes) {
                            // Set up the adapter with the combined data
                            MainAdapter mainAdapter = new MainAdapter(Categories.this, combinedList, Categories.this);
                            recyclerView.setAdapter(mainAdapter);
                            mainAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                        Toast.makeText(Categories.this, "Error fetching data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                };

                // Fetch data from each node
                node1Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node7Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node8Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node9Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node10Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node2Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node3Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node4Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node5Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                node6Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            if (item != null) {
                                combinedList.add(item);
                            }
                        }
                        checkCompletionListener.onDataChange(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        checkCompletionListener.onCancelled(databaseError);
                    }
                });

                break;

            }

            case "Sofa":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Brush":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Compact":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Consealer":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Maskara":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Lipstick":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Highlighter":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Kids Clothing":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }
            case "Kids Footwear":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Men's Clothing":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Men's Footwear":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Foundation":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Eyeliner":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Eye Shadow":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Contour":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Kids Books":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Science Fiction Books":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Romance Books":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Spatula":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Medical Solutions":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Bandages":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Medical Pills":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Refridgerator":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }



            case "Air Fryer":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }


            case "Gas Stove":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }


            case "Washing Machine":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }


            case "Television":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Cooker":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Pan":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Bed":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }

            case "Phones":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }
            case "Tabs":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }
            case "Earphones":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }
            case "Headset":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }
            case "Chargers":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }
            case "Laptop":{
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference(data);

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        categoryList = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            categorymodel item = snapshot.getValue(categorymodel.class);
                            categoryList.add(item);
                        }

                        // Set up the adapter with the fetched data
                        MainAdapter mainAdapter = new MainAdapter(Categories.this, categoryList, Categories.this);
                        recyclerView.setAdapter(mainAdapter);
                        mainAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle possible errors
                    }
                });
                break;
            }
        }
    }
    public void onItemClick(int position) {

    }
}