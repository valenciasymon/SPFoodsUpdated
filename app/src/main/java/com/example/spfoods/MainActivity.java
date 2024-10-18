package com.example.spfoods;

import android.os.Bundle;
import android.util.Log; // Import for logging
import android.widget.Toast; // Import for displaying toast messages
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView; // Import RecyclerView

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private StoreApiService storeApi;
    private RecyclerView recyclerView; // Declare RecyclerView
    private StoreAdapter storeAdapter; // Declare your adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view); // Make sure this ID matches your layout
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns

        storeApi = StoreApiClient.getRetrofitInstance().create(StoreApiService.class);


        // Call the API to fetch store data
        fetchStoreData();
    }

    private void fetchStoreData() {
        storeApi.getAllStores().enqueue(new Callback<List<Stores>>() {
            @Override
            public void onResponse(Call<List<Stores>> call, Response<List<Stores>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Stores> stores = response.body();
                    // Initialize your adapter with the store data, passing the context
                    storeAdapter = new StoreAdapter(MainActivity.this, stores);
                    recyclerView.setAdapter(storeAdapter); // Set the adapter to RecyclerView
                } else {
                    Log.e("API Error", "Response not successful or body is null");
                    Toast.makeText(MainActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Stores>> call, Throwable t) {
                Log.e("API Failure", t.getMessage());
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
