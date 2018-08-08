package com.example.francesco.mirroryoutube;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RaccoltaSuccessiva extends AppCompatActivity {

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raccolta_successiva);

        Intent i= getIntent();
        String value= i.getStringExtra("Racc");

        Intent i2 = new Intent(RaccoltaSuccessiva.this, RaccoltaFinale.class);
        i2.putExtra("Racc", value);
        button1 = findViewById(R.id.button3);


        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(i2);
            }
        });

    }
}
