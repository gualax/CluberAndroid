package com.example.cluber.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cluber.Firebase.FirebaseStore;
import com.example.cluber.R;
import com.example.cluber.adapter.ClubAdapter;
import com.example.cluber.models.Club;
import com.example.cluber.models.ClubInteractor;
import com.example.cluber.presenter.ClubListPresenter;
import com.example.cluber.interfaces.MainClubberInterface;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ClubListFragment extends Fragment implements  MainClubberInterface.view{

    final static String TAG = "ClubListFragment";
    RecyclerView mRecyclerView;
    ArrayList<Club> clubList;
    ClubAdapter mClubAdapter;
    ClubListPresenter mPresenter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_clubber_view,container,false);
        mPresenter = new ClubListPresenter(this);
        //Init Firebase
        FirebaseApp.initializeApp(getContext());
        //trigger FCM token fetching to be able to get token readily
        FirebaseInstanceId.getInstance().getToken();

        mRecyclerView = rootView.findViewById(R.id.club_recycle_view);
        mRecyclerView.setLayoutManager( new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        clubList = new ArrayList<Club>();

        mClubAdapter =  new ClubAdapter(clubList);

        // firebase conection
        FirebaseStore firebaseStore = new FirebaseStore(mPresenter);
        firebaseStore.getAllClubs();

        mRecyclerView.setAdapter(mClubAdapter);

        return  rootView;
    }

    // Devuleve un nuevo objeto del tipo ClubListPresenter
    // creacion del presenter lleva el interactor, el cual se encarga de comunicarse con el model
    protected ClubListPresenter createPresenter(Context context) {
        return new ClubListPresenter(this, new ClubInteractor());
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void ShowData(ArrayList<Club> clubList) {
        Log.e(TAG, "ShowData");
        Log.e(TAG, "" + clubList.get(0).getName());
        mClubAdapter.setAdapter(clubList);
    }

    @Override
    public void hideData() {

    }

    @Override
    public void searchInfo() {

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
}
