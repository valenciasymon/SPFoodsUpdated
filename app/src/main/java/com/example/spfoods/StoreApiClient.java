package com.example.spfoods;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StoreApiClient {
    private static final String BASE_URL = "http://192.168.237.240:3000/"; // Replace with your actual server IP if necessary
    private static Retrofit retrofit;

    // Private constructor to prevent instantiation
    private StoreApiClient() {}

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
