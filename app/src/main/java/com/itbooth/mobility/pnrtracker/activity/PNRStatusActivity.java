package com.itbooth.mobility.pnrtracker.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.itbooth.mobility.pnrtracker.R;
import com.itbooth.mobility.pnrtracker.viewmodel.PNRStatusViewModel;

public class PNRStatusActivity extends AppCompatActivity {

    PNRStatusViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnr_status);

        viewModel = new ViewModelProvider(this).get(PNRStatusViewModel.class);

        viewModel.callPNRStatusAPI();
        viewModel.callTrainSearch();
        viewModel.callStationSearch();

        viewModel.userLiveData.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

            }
        });
    }
}