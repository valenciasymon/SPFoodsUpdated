package com.example.spfoods;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

public class FoodActivity extends AppCompatActivity {
    private FoodApiService foodApiService; // Declare the FoodApiService
    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        recyclerView = findViewById(R.id.recyclerViewFood);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns

        foodApiService = FoodApiClient.getClient().create(FoodApiService.class); // Use the existing FoodApiClient

        // Retrieve the store ID and image URL from Intent extras
        int storeId = getIntent().getIntExtra("store_id", 0);
        String storeImageUrl = getIntent().getStringExtra("store_image_url");

        // Fetch food data using the store ID and pass the image URL to the adapter
        fetchFoodData(storeId, storeImageUrl);
    }

    private void fetchFoodData(int storeId, String storeImageUrl) {
        // Use the existing foodApiService to fetch food data
        foodApiService.getFoodByStore(storeId).enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("FoodActivity", "Food data: " + response.body().toString()); // Log food data
                    List<Food> foodList = response.body();
                    foodAdapter = new FoodAdapter(FoodActivity.this, foodList, storeImageUrl); // Pass storeImageUrl here
                    recyclerView.setAdapter(foodAdapter);
                } else {
                    Log.d("FoodActivity", "Failed to load food data: " + response.message()); // Log the failure message
                    Toast.makeText(FoodActivity.this, "Failed to load food data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {
                Toast.makeText(FoodActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
