package com.example.spfoods;

public class Stores {
    private int store_id;
    private String store_name;
    private String img_url;

    // Constructor
    public Stores(int store_id, String store_name, String img_url) {
        this.store_id = store_id;
        this.store_name = store_name;
        this.img_url = img_url;
    }

    // Getters
    public int getStore_id() {
        return store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public String getImg_url() {
        return img_url;
    }
}
