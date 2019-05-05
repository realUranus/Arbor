package com.realuranus.arbor;

import android.app.Application;

public class ArborApp extends Application {
    private final String BASE_URL = "https://www.lintcode.com/";

    public String getBASE_URL() {
        return BASE_URL;
    }
}
