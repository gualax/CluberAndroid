package com.example.cluber.models;

import android.widget.ImageView;


import com.google.gson.Gson;

import java.util.ArrayList;

public class Club {


    private String id;
    private String name;
    private String city;
    private String address;
    private int capacity;
    private ImageView image;
    private String imageName;
    private String imgUrl;
    private ArrayList<Table> tables;


    public Club() {}

    public Club(String name) {
        this.name = name;
    }

    public Club(String name, ImageView image) {
        this.image = image;
        this.name = name;
    }


    public ArrayList<Table> getTables() {
        return tables;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getImageName() {
        return imageName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
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



    public static Club getObjectFromStrfroing(String jsonString){
        Club club = new Gson().fromJson(jsonString,Club.class);
        return club;
    }


    public String stringFromObject(){
        Gson gson = new Gson();
        String jsonString = gson.toJson(this);
        return jsonString;

    }

}
