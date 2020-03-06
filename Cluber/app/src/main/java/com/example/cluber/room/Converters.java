package com.example.cluber.room;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import java.util.Date;

public class Converters {

    @TypeConverter
    public Date getObjectFromString(String jsonString){
        Date date = new Gson().fromJson(jsonString, Date.class);
        return date;
    }


    @TypeConverter
    public String stringFromObject(Date date) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(date);
        return jsonString;

    }

}
