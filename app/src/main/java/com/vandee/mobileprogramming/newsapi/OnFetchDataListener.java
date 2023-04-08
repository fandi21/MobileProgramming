package com.vandee.mobileprogramming.newsapi;

import com.vandee.mobileprogramming.newsapi.models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponses> {
    void onFetchData(List<NewsHeadlines> list, String message);
    void onError(String message);
}
