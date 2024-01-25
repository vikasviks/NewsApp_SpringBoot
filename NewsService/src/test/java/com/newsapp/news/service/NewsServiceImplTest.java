package com.newsapp.news.service;

import com.newsapp.news.model.News;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NewsServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private NewsServiceImpl newsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getNews_Success() {
        // Arrange
        String query = "technology";
        String apiUrl = "https://newsapi.org/v2/everything?q=" + query + "&apiKey=662fe35159ee42a0a0e46ee4aaed2f0d";
        News expectedNews = new News(); // You can create a sample News object for testing

        // Mock the behavior of the RestTemplate
        when(restTemplate.getForObject(apiUrl, News.class)).thenReturn(expectedNews);

        // Act
        News result = newsService.getNews(query);

        // Assert
        assertNotNull(result);
        assertEquals(expectedNews, result);

        // Verify that restTemplate.getForObject is called with the correct URL
        verify(restTemplate, times(1)).getForObject(apiUrl, News.class);
    }

    @Test
    void getNews_ApiError_ReturnsNull() {
        // Arrange
        String query = "invalidQuery";
        String apiUrl = "https://newsapi.org/v2/everything?q=" + query + "&apiKey=662fe35159ee42a0a0e46ee4aaed2f0d";

        // Mock the behavior of the RestTemplate to simulate an API error
        when(restTemplate.getForObject(apiUrl, News.class)).thenReturn(null);

        // Act
        News result = newsService.getNews(query);

        // Assert
        assertNull(result);

        // Verify that restTemplate.getForObject is called with the correct URL
        verify(restTemplate, times(1)).getForObject(apiUrl, News.class);
    }

    @Test
    void getNewsApiRequest_Failure_ReturnsNull() {
        // Arrange
        String query = "technology";
        String apiUrl = "https://newsapi.org/v2/everything?q=" + query + "&apiKey=662fe35159ee42a0a0e46ee4aaed2f0d";

        // Mock the behavior of the RestTemplate to simulate a failure in making the API request
        when(restTemplate.getForObject(apiUrl, News.class)).thenThrow(new RuntimeException("API request failed"));

        // Act
        News result = null;
        try {
            result = newsService.getNews(query);
        } catch (RuntimeException e) {
        }

        // Assert
        assertNull(result);

        // Verify that restTemplate.getForObject is called with the correct URL
        verify(restTemplate, times(1)).getForObject(apiUrl, News.class);
    }


//    @Test
//    void getNewsApiRequest_ResponseEntityError_ReturnsNull() {
//        // Arrange
//        String query = "technology";
//        String apiUrl = "https://newsapi.org/v2/everything?q=" + query + "&apiKey=662fe35159ee42a0a0e46ee4aaed2f0d";
//
//        // Mock the behavior of the RestTemplate to simulate a ResponseEntity with an error status
//        ResponseEntity<News> responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        when(restTemplate.getForEntity(apiUrl, News.class)).thenReturn(responseEntity);
//
//        // Act
//        News result = newsService.getNews(query);
//
//        // Assert
//        assertNull(result);
//
//        // Verify that restTemplate.getForEntity is called with the correct URL
//        verify(restTemplate, times(1)).getForEntity(apiUrl, News.class);
//    }


    // Add more test cases as needed based on your class functionality
}
