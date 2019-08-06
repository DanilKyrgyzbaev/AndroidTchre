package com.example.androidtchre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

public class LauncherActivity extends AppCompatActivity {

 //   private final static String PREF_IS_SHOWN = "is_shown";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        if (!App.appPreferences.isFirstLaunch()){
            startActivity(new Intent(this,IntroActivity.class));
            fileList();
        }else {
            MainActivity.start(this);
        }
        App.appPreferences.setLaunched();
        finish();

    }

}
