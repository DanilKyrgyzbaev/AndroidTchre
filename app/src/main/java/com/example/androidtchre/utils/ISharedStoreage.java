package com.example.androidtchre.utils;

public interface ISharedStoreage {
    void setBoolean(String key, boolean value);
    boolean getBoolean (String key,boolean defvalue);


    void remove(String key);

    boolean contains(String key);

    void clear();
}
