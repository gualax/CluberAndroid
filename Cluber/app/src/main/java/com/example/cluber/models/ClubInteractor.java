package com.example.cluber.models;


// usa retrofit y trae los model del DAO
public class ClubInteractor {

    public interface bolicheQueryData{
      void  onSucces(Club clubData);
      void  onFailure();
    }

//uso retrofit para ir a buscar la info
    void fetchBolicheData( bolicheQueryData listener){


    }



}
