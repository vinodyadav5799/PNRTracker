package com.itbooth.mobility.pnrtracker.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public final MutableLiveData<Boolean> userLiveData = new MutableLiveData<>();

    void doAction() {
        // depending on the action, do necessary business logic calls and update the
        // userLiveData.
    }
}
