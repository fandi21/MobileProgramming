package com.vandee.mobileprogramming.newsapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.vandee.mobileprogramming.R;
import com.vandee.mobileprogramming.newsapi.models.NewsApiResponses;
import com.vandee.mobileprogramming.newsapi.models.NewsHeadlines;

import java.util.List;

public class newsapi extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsapi);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Ambil Data News");
        dialog.show();

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, "null", "general");
    }

    private final OnFetchDataListener<List<NewsApiResponses>> listener = new OnFetchDataListener<List<NewsApiResponses>>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            showNews(list);
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new CustomAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }
}