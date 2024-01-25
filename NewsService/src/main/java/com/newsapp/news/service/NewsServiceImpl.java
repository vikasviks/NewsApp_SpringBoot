package com.newsapp.news.service;

import com.newsapp.news.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsServiceImpl implements NewsService{

    //add your api key here
    private static final String API_KEY = "662fe35159ee42a0a0e46ee4aaed2f0d";


    //add the base api url here
    private static final String API_URL = "https://newsapi.org/v2/everything?q=";

    private final RestTemplate restTemplate;
    public NewsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //using rest template, get the news details
//    @Override
//    public News getNewsArticle() {
//        return null;
//    }

    @Override
    public News getNews(String q) throws Exception {
        String newsUrl = API_URL  + q + "&apiKey=" + API_KEY;
       try {
           return restTemplate.getForObject(newsUrl, News.class);
       }
       catch (Exception e){
           throw new RuntimeException("Error from Third party App");
       }
    }

    @Override
    public News fetchNews(String keyword, int pageNo, int pageSize) {
        String newsUrl = API_URL  + keyword + "&apiKey=" + API_KEY + "&page=" + pageNo + "&pageSize=" +pageSize;
        try {
            return restTemplate.getForObject(newsUrl, News.class);
        }
        catch (Exception e){
            throw new RuntimeException("Error from Third party App");
        }
    }

    @Override
    public News topHeadlines(int pageNo, int pageSize) {
        String newsUrl = "https://newsapi.org/v2/top-headlines?country=in" + API_KEY + "&page=" + pageNo + "&pageSize=" +pageSize;
        try {
            return restTemplate.getForObject(newsUrl, News.class);
        }
        catch (Exception e){
            throw new RuntimeException("Error from Third party App");
        }
    }
}
