package com.newsapp.news.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {

    @Test
    void createNewsWithDefaultConstructor_Success() {
        // Arrange
        News news = new News();

        // Assert
        assertNotNull(news);
        assertNull(news.getStatus());
        assertEquals(0, news.getTotalResults());
        assertNull(news.getArticles());
    }

    @Test
    void createNewsWithParameterizedConstructor_Success() {
        // Arrange
        String status = "ok";
        int totalResults = 5;
        List<Article> articles = new ArrayList<>();

        // Act
        News news = new News(status, totalResults, articles);

        // Assert
        assertNotNull(news);
        assertEquals(status, news.getStatus());
        assertEquals(totalResults, news.getTotalResults());
        assertEquals(articles, news.getArticles());
    }

    @Test
    void addArticleToNews_Success() {
        // Arrange
        News news = new News();
        Article article = new Article();

        // Act
        news.setArticles(List.of(article));

        // Assert
        assertNotNull(news.getArticles());
        assertEquals(1, news.getArticles().size());
        assertEquals(article, news.getArticles().get(0));
    }

}
