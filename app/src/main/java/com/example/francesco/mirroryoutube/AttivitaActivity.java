package com.example.francesco.mirroryoutube;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class AttivitaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attivita);

        GridView Gridview = (GridView) findViewById(R.id.gridview);
        final String[] act=new String[]{"Attività1","Attività2","Attività3","Attività4","Attività5", "Attività6"};
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.row, R.id.textViewList, act);
        Gridview.setAdapter(arrayAdapter);
        Gridview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos, long id)
            {
                Intent i = new Intent(AttivitaActivity.this, ItemListActivity.class);
                i.putExtra("Item", act[pos]);
                startActivity(i);
            }
        });


    }
}
