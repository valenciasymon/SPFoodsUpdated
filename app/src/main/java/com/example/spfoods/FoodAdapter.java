package com.example.spfoods;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private Context context;
    private List<Food> foodList;
    private String storeImageUrl; // Add store image URL

    // Update constructor to include storeImageUrl
    public FoodAdapter(Context context, List<Food> foodList, String storeImageUrl) {
        this.context = context;
        this.foodList = foodList;
        this.storeImageUrl = storeImageUrl;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.foodNameTextView.setText(food.getFood_name());
        holder.foodPriceTextView.setText(String.valueOf(food.getFood_price()));

        // Load the individual food image
        Glide.with(context).load(food.getImg_url()).into(holder.foodImageView);

        // Load the store image (same for each item)
        Glide.with(context).load(storeImageUrl).into(holder.storeImageView);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView foodNameTextView;
        TextView foodPriceTextView;
        ImageView foodImageView;
        ImageView storeImageView; // ImageView for the store image

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodNameTextView = itemView.findViewById(R.id.food_name);
            foodPriceTextView = itemView.findViewById(R.id.food_price);
            foodImageView = itemView.findViewById(R.id.food_image);
            storeImageView = itemView.findViewById(R.id.store_image); // Ensure this ID matches item_food.xml
        }
    }
}
