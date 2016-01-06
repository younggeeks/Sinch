package com.bytech.younggeeks;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by samjunior on 1/5/2016.
 */
public class MainApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //initializing the parse app
        Parse.initialize(getApplicationContext(), "UIOOK7vROOoJRRLXfKfBGyGGU4YNFdBMUeBvrCvN", "AsBNpJPOgswKyi8ZWpL7zodYxjgjO9th57zZNMii");
    }
}
