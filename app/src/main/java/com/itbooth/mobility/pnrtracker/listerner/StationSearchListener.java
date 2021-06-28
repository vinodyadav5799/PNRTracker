package com.itbooth.mobility.pnrtracker.listerner;

import okhttp3.Response;

public interface StationSearchListener {
    void stationSearchServiceResponse(Response response);
    void stationSearchServiceErrorMessage(String message);
}
