package com.newsapp.news.controller;

import com.newsapp.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v3/")
public class NewsController {

    private final NewsService newsService;

    ResponseEntity<?> responseEntity;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/getNews/{keyword}")
    public ResponseEntity<?> getNews(@PathVariable String keyword) throws Exception{
        try {
            responseEntity = new ResponseEntity<>(newsService.getNews(keyword), HttpStatus.OK);
        }
        catch (Exception e){
            throw new RuntimeException("Third Party App Downtime");
        }
        return responseEntity;
    }

    @GetMapping("/fetchNews/{keyword}/{pageNo}/{pageSize}")
    public ResponseEntity<?> getNews(@PathVariable String keyword, @PathVariable int pageNo, @PathVariable int pageSize) {
        try {
            responseEntity = new ResponseEntity<>(newsService.fetchNews(keyword, pageNo, pageSize), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Third Party App Downtime");
        }
        return responseEntity;
    }


    @GetMapping("/topHeadlines/{pageNo}/{pageSize}")
    public ResponseEntity<?> getTopHeadlines(@PathVariable int pageNo, @PathVariable int pageSize) {
        try {
            responseEntity = new ResponseEntity<>(newsService.topHeadlines(pageNo, pageSize), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Third Party App Downtime");
        }
        return responseEntity;
    }

}
