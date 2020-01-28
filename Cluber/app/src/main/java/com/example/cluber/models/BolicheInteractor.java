package com.example.cluber.models;


// usa retrofit y trae los model del DAO
public class BolicheInteractor {

    public interface bolicheQueryData{
      void  onSucces(Boliche bolicheData);
      void  onFailure();
    }

//uso retrofit para ir a buscar la info
    void fetchBolicheData( bolicheQueryData listener){


    }



}
