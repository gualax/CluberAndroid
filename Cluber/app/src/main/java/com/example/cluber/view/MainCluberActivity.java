package com.example.cluber.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cluber.R;
import com.example.cluber.adapter.ClubAdapter;
import com.example.cluber.base.BaseActivity;
import com.example.cluber.models.Club;
import com.example.cluber.models.ClubInteractor;
import com.example.cluber.presenter.MainCluberPresenter;
import com.example.cluber.view.interfaces.MainClubberInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/*
* Activity principal
* Extiende del presenter MainClubberPresenter
* Implementa MainClubberInterface
* La vista corresponde a main_clubber_view
* Y muestra la panatlla principal con los tabs
* */

public class MainCluberActivity extends BaseActivity<MainCluberPresenter> implements MainClubberInterface.view {

    //modelos de vista textos, imgagenes etc...

  RecyclerView mRecyclerView;
  RecyclerView.Adapter mAdapter;
  RecyclerView.LayoutManager mLayoutManager;

  ArrayList<Club> clubList;


   @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_clubber_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.club_recycle_view);
        mRecyclerView.setLayoutManager( new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        clubList = new ArrayList<Club>();

       populateListByJsonFile(clubList);

       ClubAdapter clubAdapter =  new ClubAdapter(clubList);
       mRecyclerView.setAdapter(clubAdapter);
//       clubAdapter.notifyDataSetChanged();
   }

    private void populateListByJsonFile(ArrayList<Club> clubList) {
        Log.d("CLUBER","populateList");
        InputStream is = getResources().openRawResource(R.raw.club_sample_data);
        String jsonString = new Scanner(is).useDelimiter("\\A").next();
        Log.d("CLUBER",jsonString);
        try {
            JSONObject json = new JSONObject(jsonString);
            JSONArray jsonArray = json.getJSONArray("clubs");

            for(int i=0;i<jsonArray.length();i++){
                JSONObject obj=new JSONObject(jsonArray.get(i).toString());
                Club club = new Club();
                club.setName(obj.getString("name"));
                club.setCity(obj.getString("city"));
                club.setAddress(obj.getString("address"));
                club.setCapacity(obj.getInt("capacity"));
                club.setImageName(obj.getString("img"));
                clubList.add(club);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // Devuleve un nuevo objeto del tipo MainCluberPresenter
    // creacion del presenter lleva el interactor, el cual se encarga de comunicarse con el model
    @Override
    protected MainCluberPresenter createPresenter(Context context) {
        return new MainCluberPresenter(this, new ClubInteractor());
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void ShowData() {

    }

    @Override
    public void hideData() {

    }

    @Override
    public void searchInfo() {

    }

    public Context getAppContext(){
       return  this;
    }
}
