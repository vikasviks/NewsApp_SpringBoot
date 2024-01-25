//package com.newsapp.wishlist.exception;
//
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//class NewsArticleAlreadyExistsTest {
//
//    @Test
//    void newsArticleAlreadyExists_WithMessage_Success() {
//        // Arrange
//        String errorMessage = "News article already exists";
//
//        // Act
//        NewsArticleAlreadyExists exception = new NewsArticleAlreadyExists(errorMessage);
//
//        // Assert
//        assertNotNull(exception);
//        assertEquals(errorMessage, exception.getMessage());
//    }
//
//    @Test
//    void newsArticleAlreadyExists_WithoutMessage_Success() {
//        // Act
//        NewsArticleAlreadyExists exception = new NewsArticleAlreadyExists();
//
//        // Assert
//        assertNotNull(exception);
//        assertNull(exception.getMessage());
//    }
//}
