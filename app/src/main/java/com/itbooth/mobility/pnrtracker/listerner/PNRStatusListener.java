package com.itbooth.mobility.pnrtracker.listerner;

import okhttp3.Response;

public interface PNRStatusListener {
    void pnrStatusServiceResponse(Response response);
    void pnrStatusServiceErrorMessage(String message);
}
