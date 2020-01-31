package com.example.cluber;

import android.app.Application;
import android.content.Context;

public class ClubberApp extends Application {


        private static ClubberApp instance;

        public ClubberApp() {
            instance = this;
        }

        public static Context getContext() {
            return instance;
        }
}
