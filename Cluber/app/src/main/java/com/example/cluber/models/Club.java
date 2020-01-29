package com.example.cluber.models;

import android.widget.ImageView;

public class Club {

    private String name;
    private String city;
    private int capacity;
    private ImageView image;

    public Club() {}

    public Club(String name) {
        this.name = name;
    }

    public Club(String name, ImageView image) {
        this.image = image;
        this.name = name;
    }


    public void setImage(ImageView image){
        this.image = image;
    }

    public ImageView getImage(){
            return  this.image;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
