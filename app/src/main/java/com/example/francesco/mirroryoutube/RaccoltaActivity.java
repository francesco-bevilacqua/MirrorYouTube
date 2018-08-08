package com.example.francesco.mirroryoutube;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RaccoltaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raccolta);


        ListView listView = (ListView) findViewById(R.id.listview);
        final String[] stuff = new String[]{"Raccolta1", "Raccolta2", "Raccolta3", "Raccolta4", "Raccolta5", "Raccolta6"};
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.row, R.id.textViewList, stuff);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
                Intent i = new Intent(RaccoltaActivity.this, RaccoltaSuccessiva.class);
                i.putExtra("Racc", stuff[pos]);
                startActivity(i);
            }
        });
    }
}
