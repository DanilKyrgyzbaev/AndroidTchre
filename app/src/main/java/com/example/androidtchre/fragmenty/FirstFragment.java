package com.example.androidtchre.fragmenty;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidtchre.MainActivity;
import com.example.androidtchre.R;


public class FirstFragment extends Fragment {

    TextView textView;

    public static FirstFragment newInstance(int page) {


        Bundle args = new Bundle();

        FirstFragment fragment = new FirstFragment();
        args.putInt("pos",page);
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_first,container,false);
        ImageView imageView = rootView.findViewById(R.id.image_view_first);
        TextView textView = (TextView) rootView.findViewById(R.id.first_fragment_text_view);
        int pos = getArguments().getInt("pos");
        switch (pos){
            case 0:
                imageView.setImageResource(R.drawable.ic_second_fragment);
                textView.setText("second fragment");
                break;

            case 1:
                imageView.setImageResource(R.drawable.ic_three_fragment);
                textView.setText("three fragment");
                break;
            case 2:
                imageView.setImageResource(R.drawable.ic_first_fragment);
                textView.setText("one fragment");
                break;

        }
        return  rootView;


    }

}
