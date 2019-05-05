package com.realuranus.arbor;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ArborActivity extends AppCompatActivity {
    private final String TAG = "ArborActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arbor);

        Logger.addLogAdapter(new AndroidLogAdapter());

        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
//        sharedPreferences.getString(getString(R.string.app_launch_time), Context.MODE_PRIVATE);

        new Thread(){
            @Override
            public void run() {
//                super.run();
                try {
                    Document document = Jsoup.connect("https://www.lintcode.com/").get();
                    String title = document.title();
                    Logger.t(TAG).i(title);
                }catch (IOException e){
                }
            }
        }.start();

    }
}
