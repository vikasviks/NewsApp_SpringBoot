package com.newsapp.news.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArticleTest {

    @Test
    void createArticleWithDefaultConstructor_Success() {
        // Arrange
        Article article = new Article();

        // Assert
        assertNotNull(article);
        assertNull(article.getSource());
        assertNull(article.getAuthor());
        assertNull(article.getTitle());
        assertNull(article.getDescription());
        assertNull(article.getUrl());
        assertNull(article.getUrlToImage());
        assertNull(article.getPublishedAt());
        assertNull(article.getContent());
    }

    @Test
    void createArticleWithParameterizedConstructor_Success() {
        // Arrange
        Source source = new Source("sourceId", "sourceName");
        String author = "John Doe";
        String title = "Sample Article";
        String description = "This is a sample article.";
        String url = "https://example.com";
        String urlToImage = "https://example.com/image.jpg";
        String publishedAt = "2023-01-01T12:00:00Z";
        String content = "This is the content of the article.";

        // Act
        Article article = new Article(source, author, title, description, url, urlToImage, publishedAt, content);

        // Assert
        assertNotNull(article);
        assertEquals(source, article.getSource());
        assertEquals(author, article.getAuthor());
        assertEquals(title, article.getTitle());
        assertEquals(description, article.getDescription());
        assertEquals(url, article.getUrl());
        assertEquals(urlToImage, article.getUrlToImage());
        assertEquals(publishedAt, article.getPublishedAt());
        assertEquals(content, article.getContent());
    }

}
