package com.itbooth.mobility.pnrtracker.listerner;

import okhttp3.Response;

public interface TrainSearchListener {
    void trainSearchServiceResponse(Response response);
    void trainSearchServiceErrorMessage(String message);
}
