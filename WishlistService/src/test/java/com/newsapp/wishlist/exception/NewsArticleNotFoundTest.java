//package com.newsapp.wishlist.exception;
//
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//class NewsArticleNotFoundTest {
//
//    @Test
//    void newsArticleNotFound_WithMessage_Success() {
//        // Arrange
//        String errorMessage = "News article not found";
//
//        // Act
//        NewsArticleNotFound exception = new NewsArticleNotFound(errorMessage);
//
//        // Assert
//        assertNotNull(exception);
//        assertEquals(errorMessage, exception.getMessage());
//    }
//
//    @Test
//    void newsArticleNotFound_WithoutMessage_Success() {
//        // Act
//        NewsArticleNotFound exception = new NewsArticleNotFound();
//
//        // Assert
//        assertNotNull(exception);
//        assertNull(exception.getMessage());
//    }
//}
