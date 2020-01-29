package com.example.cluber.presenter;

import androidx.annotation.NonNull;

import com.example.cluber.base.BasePresenter;
import com.example.cluber.models.Club;
import com.example.cluber.models.ClubInteractor;
import com.example.cluber.view.interfaces.MainClubberInterface;

public class MainCluberPresenter extends BasePresenter implements ClubInteractor.bolicheQueryData {

    private  MainClubberInterface.view view;
    private ClubInteractor interactor;
    public MainCluberPresenter(@NonNull MainClubberInterface.view view, ClubInteractor interactor) {
          this.view = view;
          this.interactor = interactor;
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
}
