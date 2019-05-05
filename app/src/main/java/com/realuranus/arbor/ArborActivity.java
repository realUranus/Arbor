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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
                    Document document = Jsoup.connect((APP_DATA.getProblemUrl())).get();
                    String title = document.title();
                    Elements links = document.select("a[href]");
                    Logger.t(TAG).i("links:");
                    for (Element e : links){
                        Logger.t(TAG).i(e.tagName() + e.text());
                    }
//                    String body = document.body();
//                    Logger.t(TAG).i();
                }catch (IOException e){
                }
            }
        }.start();
    }
}
