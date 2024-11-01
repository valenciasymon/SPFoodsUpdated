package com.example.spfoods;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StoreApiService {
    @GET("stores") // API endpoint to get all stores
    Call<List<Stores>> getAllStores();
}
