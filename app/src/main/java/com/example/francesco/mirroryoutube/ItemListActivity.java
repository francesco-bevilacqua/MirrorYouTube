package com.example.francesco.mirroryoutube;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.francesco.mirroryoutube.Network.OkHttpProvider;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ItemListActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        Intent i= getIntent();
        String value="";
        value = i.getStringExtra("Name");
        TextView title = findViewById(R.id.textView4);
        String finaValue="";

        switch (value){

            case "ItemMain":
                finaValue= value + "'s Videos Main";

            case "ItemHome":
                finaValue= value + "'s Videos Home";

            case "ItemIscrizioni":
                finaValue= value + "'s Videos Iscrizioni";

            case "ItemSearch":
                finaValue= value + "'s Videos Search";


        }

        title.setText(finaValue);


        handler = new Handler(getMainLooper());
        getUrl();

        }

    private void getUrl() {

        Intent i =getIntent();
        String value = i.getStringExtra("Name");


        OkHttpClient client = OkHttpProvider.getInstance().getOkHttpClient();
        Request request = new Request.Builder().url("https://it.wikipedia.org/wiki/"+value).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                handler.post(() -> {
                    TextView tv = (TextView) findViewById(R.id.textView);
                    try {
                        tv.setText(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        });

    }




}
