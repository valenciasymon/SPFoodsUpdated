package com.example.spfoods;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StoreDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        // Retrieve the data from the Intent
        int storeId = getIntent().getIntExtra("store_id", -1);
        String storeName = getIntent().getStringExtra("store_name");

        // Use storeId or storeName to fetch more details and display them in the UI
        TextView storeNameTextView = findViewById(R.id.store_name); // Example TextView
        storeNameTextView.setText(storeName); // Set the store name
    }
}
