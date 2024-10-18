package com.example.spfoods;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FoodApiService {
    @GET("store/{store_id}/food") // Ensure this matches your API endpoint
    Call<List<Food>> getFoodByStore(@Path("store_id") int storeId);
}

