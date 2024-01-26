package com.newsapp.news.service;

import com.newsapp.news.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsServiceImpl implements NewsService{

    //add your api key here
    @Value("${api.key}")
    private String API_KEY;


    //add the base api url here
    @Value("${api.url}")
    private String API_URL;

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
        String newsUrl = "https://newsapi.org/v2/top-headlines?country=in&apiKey=" + API_KEY + "&page=" + pageNo + "&pageSize=" +pageSize;
        try {
            return restTemplate.getForObject(newsUrl, News.class);
        }
        catch (Exception e){
            throw new RuntimeException("Error from Third party App");
        }
    }
}
