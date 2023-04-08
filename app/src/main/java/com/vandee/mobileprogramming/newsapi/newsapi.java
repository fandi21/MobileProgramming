package com.vandee.mobileprogramming.newsapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.vandee.mobileprogramming.R;
import com.vandee.mobileprogramming.newsapi.models.NewsApiResponses;
import com.vandee.mobileprogramming.newsapi.models.NewsHeadlines;

import java.util.List;

public class newsapi extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsapi);

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, "null", "general");
    }

    private final OnFetchDataListener<NewsApiResponses> listener = new OnFetchDataListener<NewsApiResponses>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            showNews(list);
        }

        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager());
    }
}