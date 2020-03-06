package com.example.cluber.presenter;

import androidx.annotation.NonNull;

import com.example.cluber.base.BasePresenter;
import com.example.cluber.models.Club;
import com.example.cluber.models.ClubInteractor;
import com.example.cluber.interfaces.MainClubberInterface;

import java.util.ArrayList;

public class ClubListPresenter extends BasePresenter implements ClubInteractor.bolicheQueryData, MainClubberInterface.presenter {

    private MainClubberInterface.view view;
    private ClubInteractor interactor;
    public ClubListPresenter(@NonNull MainClubberInterface.view view, ClubInteractor interactor) {
          this.view = view;
          this.interactor = interactor;
    }

    public ClubListPresenter(@NonNull MainClubberInterface.view view) {
        this.view = view;
    }


    //callback de succes del interactor disparado cuando pudo buscar los datos
    //y los mismos estan en clubData
    @Override
    public void onSucces(Club clubData) {
        //mostrar datos
        //view.show
    }

    //callback de failure del interactor disparado cuando falla la busqueda de datos
    @Override
    public void onFailure() {
        //mostrar error
    }

    @Override
    public void searchData() {

    }

    @Override
    public void dataClubChanged(ArrayList<Club> clubList) {
        view.ShowData(clubList);
    }
}
