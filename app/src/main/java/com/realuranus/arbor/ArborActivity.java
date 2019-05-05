package com.realuranus.arbor;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArborActivity extends AppCompatActivity {
    private final String TAG = "ArborActivity";
    private ArrayList<String> problem_data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arbor);

        Logger.addLogAdapter(new AndroidLogAdapter());

        problem_data.add("One");
        problem_data.add("Two");

//        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
//        sharedPreferences.getString(getString(R.string.app_launch_time), Context.MODE_PRIVATE);

        new Thread(){
            @Override
            public void run() {
                try {
                    Document document = Jsoup.connect((APP_DATA.getBASE_URL())).get();
                    String title = document.title();
                    Elements links = document.select(APP_DATA.getProblemSelector());
                    Logger.t(TAG).i("links:");
                    for (Element e : links){
                        problem_data.add(e.text());
                    }
                }catch (IOException e){
                }
            }
        }.start();

        ListView problem_lv = (ListView)findViewById(R.id.problem_list);
        problem_lv.setAdapter(new ArrayAdapter<String>(this, R.layout.problem_item,problem_data));
    }
}
