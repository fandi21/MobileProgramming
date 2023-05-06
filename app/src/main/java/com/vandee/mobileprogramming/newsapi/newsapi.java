package com.vandee.mobileprogramming.newsapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.vandee.mobileprogramming.MainActivity;
import com.vandee.mobileprogramming.R;
import com.vandee.mobileprogramming.newsapi.models.NewsApiResponses;
import com.vandee.mobileprogramming.newsapi.models.NewsHeadlines;

import java.util.List;

public class newsapi extends AppCompatActivity implements SelectListener {
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
        manager.getNewsHeadlines(listener, null, "general");
    }

    private final OnFetchDataListener<NewsApiResponses> listener = new OnFetchDataListener<NewsApiResponses>() {
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
        adapter = new CustomAdapter(this, list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnNewsClicked(NewsHeadlines headlines) {
        startActivity(new Intent(this, DetailActivity.class)
                .putExtra("data", headlines));
    }
}