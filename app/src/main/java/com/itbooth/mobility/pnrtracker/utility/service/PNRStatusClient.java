package com.itbooth.mobility.pnrtracker.utility.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.itbooth.mobility.pnrtracker.listerner.PNRStatusListener;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PNRStatusClient {
    public String mURL = "https://indianrailways.p.rapidapi.com/index.php?pnr=";
    public String mRapidAPIKey = "8cb04c4113mshdf49d0071107837p1dd645jsn4cce232c9c22";
    public String mRapidAPIHost = "indianrailways.p.rapidapi.com";
    PNRStatusListener mListener;

    public void callPNRStatusService(String pnr, PNRStatusListener listener) {
        mListener = listener;
        OkHttpClient mClient = new OkHttpClient();
        final MediaType headerRequest = MediaType.parse("application/json; charset=utf-8");

        Request request = new Request.Builder()
                .url(mURL+"4502083295")
                .get()
                .addHeader("x-rapidapi-key", mRapidAPIKey)
                .addHeader("x-rapidapi-host", mRapidAPIHost)
                .build();

        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                mListener.pnrStatusServiceResponse(response);
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                mListener.pnrStatusServiceErrorMessage(e.getMessage());
            }
        });
    }

}
