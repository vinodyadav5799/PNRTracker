package com.itbooth.mobility.pnrtracker.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.itbooth.mobility.pnrtracker.R;
import com.itbooth.mobility.pnrtracker.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.userLiveData.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

            }
        });
        */

    }
}