package com.example.cluber.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.cluber.R;
import com.example.cluber.base.BaseActivity;
import com.example.cluber.models.BolicheInteractor;
import com.example.cluber.presenter.MainCluberPresenter;
import com.example.cluber.view.interfaces.MainClubberInterface;

/*
* Activity principal
* Extiende del presenter MainClubberPresenter
* Implementa MainClubberInterface
* La vista corresponde a main_clubber_view
* Y muestra la panatlla principal con los tabs
* */

public class MainCluberActivity extends BaseActivity<MainCluberPresenter> implements MainClubberInterface.view {

    //modelos de vista textos, imgagenes etc...



   @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_clubber_view);

    }

    // Devuleve un nuevo objeto del tipo MainCluberPresenter
    // creacion del presenter lleva el interactor, el cual se encarga de comunicarse con el model
    @Override
    protected MainCluberPresenter createPresenter(Context context) {
        return new MainCluberPresenter(this, new BolicheInteractor());
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
}
