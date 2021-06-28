package com.itbooth.mobility.pnrtracker.utility.service;

import com.itbooth.mobility.pnrtracker.listerner.StationSearchListener;
import com.itbooth.mobility.pnrtracker.listerner.TrainSearchListener;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class StationSearchClient {
    public String mURL = "https://trains.p.rapidapi.com/";
    public String mRapidAPIKey = "8cb04c4113mshdf49d0071107837p1dd645jsn4cce232c9c22";
    public String mRapidAPIHost = "trains.p.rapidapi.com";
    StationSearchListener mListener;

   public void callStationSearchService(String stationSearch, StationSearchListener listener) {
        mListener = listener;
        OkHttpClient mClient = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\"search\": \"Rajdhani\"\r}");

        Request request = new Request.Builder()
            .url(mURL)
            .post(body)
            .addHeader("content-type", "application/json")
            .addHeader("x-rapidapi-key", mRapidAPIKey)
            .addHeader("x-rapidapi-host", mRapidAPIHost)
            .build();

        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                mListener.stationSearchServiceResponse(response);
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                mListener.stationSearchServiceErrorMessage(e.getMessage());
            }
        });
    }
}
