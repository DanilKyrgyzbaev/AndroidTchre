package com.example.androidtchre.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedStoreage  implements ISharedStoreage{
    private SharedPreferences preferences;


    public SharedStoreage(Context context,String preferencesName){
        preferences = context.getSharedPreferences(preferencesName,Context.MODE_PRIVATE);


    }


    @Override
    public void setBoolean(String key, boolean value) {
        preferences.edit().putBoolean(key,value).apply();

    }

    @Override
    public boolean getBoolean(String key, boolean defvalue) {
        return preferences.getBoolean(key,defvalue);
    }
    @Override
    public void  remove(String key){
         preferences.edit().remove(key).apply();
    }

    @Override
    public boolean contains(String key){
        return preferences.contains(key);
    }

    @Override
    public void clear() {
        preferences.edit().clear().apply();

    }
}
