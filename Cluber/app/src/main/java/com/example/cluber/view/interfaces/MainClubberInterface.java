package com.example.cluber.view.interfaces;

public interface  MainClubberInterface {

    interface view {
        void showProgressBar();

        void ShowData();

        void hideData();

        void searchInfo();
    }

    interface presenter{
        void searchData();

    }

}
