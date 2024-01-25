//package com.newsapp.news.controller;
//
//import com.newsapp.news.model.News;
//import com.newsapp.news.service.NewsService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//class NewsControllerTest {
//
//    @Mock
//    private NewsService newsService;
//
//    @InjectMocks
//    private NewsController newsController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void getNews_Success() {
//        String keyword = "technology";
//        News news = new News(/* construct your News object */);
//        when(newsService.getNews(keyword)).thenReturn(news);
//
//        ResponseEntity<?> responseEntity = newsController.getNews(keyword);
//
//        assertNotNull(responseEntity);
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertNotNull(responseEntity.getBody());
//        assertEquals(news, responseEntity.getBody());
//    }
//}
