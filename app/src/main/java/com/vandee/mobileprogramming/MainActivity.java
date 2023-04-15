package com.vandee.mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMdl1, btnMdl2, MenuPerhitungan, dsbh, newsApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMdl1 = findViewById(R.id.btnModul1);
        btnMdl2 = findViewById(R.id.btnModul2);
        MenuPerhitungan = findViewById(R.id.btnPerhitungan);
        dsbh = findViewById(R.id.btnDashboard);
        newsApi = findViewById(R.id.btnNewsApi);

        btnMdl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, modul1.class);
                startActivity(intent);
            }
        });

        btnMdl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PengenalannVariable.class);
                startActivity(intent);
            }
        });

        MenuPerhitungan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.vandee.mobileprogramming.MenuPerhitungan.class);
                startActivity(intent);
            }
        });

        dsbh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.vandee.mobileprogramming.dashboard.dashboard.class);
                startActivity(intent);
            }
        });

        newsApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.vandee.mobileprogramming.newsapi.newsapi.class);
                startActivity(intent);
            }
        });
    }
}