package com.itbooth.mobility.pnrtracker.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.itbooth.mobility.pnrtracker.listerner.PNRStatusListener;
import com.itbooth.mobility.pnrtracker.listerner.StationSearchListener;
import com.itbooth.mobility.pnrtracker.listerner.TrainSearchListener;
import com.itbooth.mobility.pnrtracker.utility.service.PNRStatusClient;
import com.itbooth.mobility.pnrtracker.utility.service.StationSearchClient;
import com.itbooth.mobility.pnrtracker.utility.service.TrainSearchClient;

import okhttp3.Response;

public class PNRStatusViewModel extends ViewModel {
    public final MutableLiveData<Boolean> userLiveData = new MutableLiveData<>();

    public void callPNRStatusAPI() {
        new PNRStatusClient().callPNRStatusService("", new PNRStatusListener() {
            @Override
            public void pnrStatusServiceResponse(Response response) {
                try {
                    if (response.isSuccessful()) {
                        JsonObject jObj = new Gson().fromJson(response.body().string(), JsonObject.class);
                    }
                } catch (Exception e) {
                    Log.e("error", e.getMessage());
                }
            }

            @Override
            public void pnrStatusServiceErrorMessage(String message) {
                Log.e("response", message);
            }
        });
    }

    public void callTrainSearch() {
        new TrainSearchClient().callTrainSearchService("", new TrainSearchListener() {
            @Override
            public void trainSearchServiceResponse(Response response) {
                try {
                    if (response.isSuccessful()) {
                        JsonArray jArr = new Gson().fromJson(response.body().string(), JsonArray.class);
                    }
                } catch (Exception e) {
                    Log.e("error", e.getMessage());
                }
            }

            @Override
            public void trainSearchServiceErrorMessage(String message) {
                Log.e("error", message);
            }
        });
    }

    public void callStationSearch() {
        new StationSearchClient().callStationSearchService("", new StationSearchListener() {
            @Override
            public void stationSearchServiceResponse(Response response) {
                try {
                    if (response.isSuccessful()) {
                        JsonArray jArr = new Gson().fromJson(response.body().string(), JsonArray.class);
                    }
                } catch (Exception e) {
                    Log.e("error", e.getMessage());
                }
            }

            @Override
            public void stationSearchServiceErrorMessage(String message) {
                Log.e("error", message);
            }

        });
    }
}
