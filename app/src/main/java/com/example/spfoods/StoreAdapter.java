package com.example.spfoods;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {

    private Context context;
    private List<Stores> storeList;

    // Constructor to initialize context and store list
    public StoreAdapter(Context context, List<Stores> storeList) {
        this.context = context;
        this.storeList = storeList;
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.store_item, parent, false);
        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {
        // Get the store object for the current position
        Stores store = storeList.get(position);
        Log.d("Store Data", "Name: " + store.getStore_name() + ", Image URL: " + store.getImg_url());

        // Set the store name
        holder.storeName.setText(store.getStore_name());

        // Load the store image using Glide (ensure the URL is valid)
        Glide.with(context)
                .load(store.getImg_url())
                .into(holder.storeImage);

        // Set OnClickListener to open a new activity with store details
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start the new activity (StoreDetailActivity)
                Intent intent = new Intent(context, FoodActivity.class);

                // Pass the store details (store ID or name) to the next activity
                intent.putExtra("store_id", store.getStore_id()); // Use store.getStore_id() for store ID
                intent.putExtra("store_name", store.getStore_name()); // Optionally pass the name

                // Start the new activity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        // Return the number of stores in the list
        return storeList.size();
    }

    // ViewHolder class to bind views in the store_item layout
    public static class StoreViewHolder extends RecyclerView.ViewHolder {
        TextView storeName; // TextView for the store name
        ImageView storeImage; // ImageView for the store image

        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);
            // Bind the views from the layout
            storeName = itemView.findViewById(R.id.store_name);
            storeImage = itemView.findViewById(R.id.store_image);
        }
    }
}
