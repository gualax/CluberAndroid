package com.example.cluber.interfaces;

import com.example.cluber.models.Club;

import java.util.ArrayList;

public interface  MainClubberInterface {

    interface view {
        void showProgressBar();

        void ShowData(ArrayList<Club> clubList);

        void hideData();

        void searchInfo();
    }

    interface presenter{
        void searchData();

        void dataClubChanged(ArrayList<Club> clubList);

    }

}
