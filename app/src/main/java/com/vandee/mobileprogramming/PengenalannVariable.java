package com.vandee.mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PengenalannVariable extends AppCompatActivity {

    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalann_variable);

        txtHasil = findViewById(R.id.hasil);

        int hasil, a, b;
        a = 10;
        b = 20;
        hasil = a + b;

        txtHasil.setText(String.valueOf(hasil));
    }
}