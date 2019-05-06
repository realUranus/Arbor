package com.realuranus.arbor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.realuranus.arbor.activity.ProblemDetailActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArborActivity extends AppCompatActivity {
    private final String TAG = "ArborActivity";

    //ListView
    private ArrayList<String> problem_data = new ArrayList<>();
    private ArrayAdapter<String> problem_adapter = null;

    //Handler
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Logger.t(TAG).i("data update");
            problem_adapter.notifyDataSetChanged();
        }
    };

    //click
    private AdapterView.OnItemClickListener lvClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Logger.t(TAG).i("Clicked");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arbor);

        Logger.addLogAdapter(new AndroidLogAdapter());

        Intent intent = new Intent(getApplicationContext(), ProblemDetailActivity.class);
        intent.putExtra("link","https://www.nowcoder.com/practice/f983806a2ecb4106a17a365a642a9632?tpId=46&tqId=29049&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking");
        startActivity(intent);

        problem_adapter =  new ArrayAdapter<String>(this, R.layout.problem_item, problem_data);
        problem_data.add("One");
        problem_data.add("Two");

        new Thread(){
            @Override
            public void run() {
                try {
                    Document document = Jsoup.connect((APP_DATA.getBASE_URL())).get();
                    String title = document.title();
                    Elements links = document.select(APP_DATA.getProblemSelector());
                    Logger.t(TAG).i("links:");
//                    for (Element e : links){
//                        problem_data.add(e.text());
//                    }
//                    mHandler.sendEmptyMessage(0);
                    }catch (IOException e){
                }
            }
        }.start();

        ListView problem_lv = (ListView)findViewById(R.id.problem_list);
        problem_lv.setAdapter(new ArrayAdapter<String>(this, R.layout.problem_item,problem_data));
        problem_lv.setOnItemClickListener(lvClickListener);

    }
}
