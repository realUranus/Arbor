package com.realuranus.arbor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ArborActivity extends AppCompatActivity {
    private final String TAG = "ArborActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arbor);

        try {
            Document document = Jsoup.connect("https://www.lintcode.com/").get();
            String title = document.title();
            Log.d(TAG, title);
        }catch (IOException e){

        }

    }
}
