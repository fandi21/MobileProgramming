package com.vandee.mobileprogramming.perhitungan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vandee.mobileprogramming.R;

public class LuasPersegiPanjang extends AppCompatActivity {

    EditText p, l;
    Button hitung;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas_persegi_panjang);

        p = findViewById(R.id.etNilaiPanjang);
        l = findViewById(R.id.etNilaiLebar);
        hitung = findViewById(R.id.btnHitung);
        hasil = findViewById(R.id.tvHasil);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Jika panjang dan Lebar tidak diisi akan tampil notif error
                if(p.length() == 0 && l.length() == 0){
                    Toast.makeText(getApplication(),"Panjang dan Lebar Tidak Boleh Kosong",
                            Toast.LENGTH_LONG).show();
                }else if(p.length() == 0){
                    Toast.makeText(getApplication(),"Panjang Tidak Boleh Kosong",
                            Toast.LENGTH_LONG).show();
                }else if(l.length() == 0){
                    Toast.makeText(getApplication(),"Lebar Tidak Boleh Kosong",
                            Toast.LENGTH_LONG).show();
                }else{
                    //Ubah dari text ke string
                    String isiPanjang = p.getText().toString();
                    String isiLebar = l.getText().toString();

                    //ubah dari string ke Double/FLoat
                    double pa = Double.parseDouble(isiPanjang);
                    double le = Double.parseDouble(isiLebar);
                    double hs = LuasPersegiPanjang(pa,le);

                    String output = String.valueOf(hs);
                    hasil.setText(output.toString());
                }
            }
        });
    }

    public double LuasPersegiPanjang(double p, double l){
        return p*l;
    }
}