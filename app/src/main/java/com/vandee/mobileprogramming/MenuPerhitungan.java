package com.vandee.mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vandee.mobileprogramming.perhitungan.LuasPersegiPanjang;

public class MenuPerhitungan extends AppCompatActivity {

    Button lpp, lst, ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_perhitungan);

        lpp = findViewById(R.id.btnPersegiPanjang);

        lpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPerhitungan.this, LuasPersegiPanjang.class);
                startActivity(intent);
            }
        });
    }
}