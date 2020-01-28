package com.example.cluber.presenter;

import androidx.annotation.NonNull;

import com.example.cluber.base.BasePresenter;
import com.example.cluber.models.Boliche;
import com.example.cluber.models.BolicheInteractor;
import com.example.cluber.view.interfaces.MainClubberInterface;

public class MainCluberPresenter extends BasePresenter implements BolicheInteractor.bolicheQueryData {

    private  MainClubberInterface.view view;
    private  BolicheInteractor interactor;
    public MainCluberPresenter(@NonNull MainClubberInterface.view view, BolicheInteractor interactor) {
          this.view = view;
          this.interactor = interactor;
    }


    //callback de succes del interactor disparado cuando pudo buscar los datos
    //y los mismos estan en bolicheData
    @Override
    public void onSucces(Boliche bolicheData) {
        //mostrar datos
        //view.show
    }

    //callback de failure del interactor disparado cuando falla la busqueda de datos
    @Override
    public void onFailure() {
        //mostrar error
    }
}
