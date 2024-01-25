package com.newsapp.news.service;

import com.newsapp.news.model.News;

public interface NewsService {

//    News getNewsArticle();

    News getNews(String q) throws Exception;

    News fetchNews(String keyword, int pageNo, int pageSize);

    News topHeadlines(int pageNo, int pageSize);
}
