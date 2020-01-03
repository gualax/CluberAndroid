package com.example.cluber.base;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class BasePresenter {


    //Clase abstracta que declara los metodos del ciclo de vida de la activity para
    //de esta manera estar alineados con ellos

    public BasePresenter() {
    }

    @CallSuper
     void onCreate(@Nullable final Bundle savedInstance){
     }

    @CallSuper
    void onStart() {
    }

    @CallSuper
    void onResume() {
    }

    @CallSuper
    void onStop() {
    }

    @CallSuper
    void onPause() {
    }

    @CallSuper
    void onDestroy() {
    }

    @CallSuper
    void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    }


    @CallSuper
    void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    }

}
