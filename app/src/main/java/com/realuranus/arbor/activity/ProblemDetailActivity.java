package com.realuranus.arbor.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.orhanobut.logger.Logger;

public class ProblemDetailActivity extends AppCompatActivity {

    private final String TAG = "ProblemDetailActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle e = getIntent().getExtras();
        Logger.t(TAG).i(e.getString("link"));
    }
}