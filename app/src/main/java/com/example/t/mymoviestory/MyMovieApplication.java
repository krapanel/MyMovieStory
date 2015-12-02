package com.example.t.mymoviestory;

import android.app.Application;
import android.content.Context;

/**
 * Created by T on 2015-11-09.
 */
public class MyMovieApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
