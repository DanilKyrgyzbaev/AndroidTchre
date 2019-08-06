package com.example.androidtchre;

import android.app.Application;
import com.example.androidtchre.utils.AppPreferences;
import com.example.androidtchre.utils.ISharedStoreage;
import com.example.androidtchre.utils.SharedStoreage;

public class App extends Application {

    public static ISharedStoreage sharedStoreage;
    public static AppPreferences appPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedStoreage = new SharedStoreage(this,"prefs");
        appPreferences = new AppPreferences(sharedStoreage);
    }
}
