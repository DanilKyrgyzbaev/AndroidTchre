package com.example.androidtchre.utils;

public class AppPreferences {

    private static final String PREF_IS_FIRST_LAUNCH = "is_first_launch";

    private ISharedStoreage sharedStoreage;

    public AppPreferences(ISharedStoreage sharedStoreage) {
        this.sharedStoreage = sharedStoreage;

    }
    public boolean isFirstLaunch(){
        return sharedStoreage.getBoolean(PREF_IS_FIRST_LAUNCH,true);
    }
    public void setLaunched(){
        sharedStoreage.setBoolean(PREF_IS_FIRST_LAUNCH,false);
    }
}
