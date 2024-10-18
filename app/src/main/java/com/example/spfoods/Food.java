package com.example.spfoods;

public class Food {
    private int food_id;
    private String food_name;
    private double food_price;
    private String img_url;

    // Constructor
    public Food(int food_id, String food_name, double food_price, String img_url) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.food_price = food_price;
        this.img_url = img_url;
    }

    // Getters
    public int getFood_id() {
        return food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public double getFood_price() {
        return food_price;
    }

    public String getImg_url() {
        return img_url;
    }
}
