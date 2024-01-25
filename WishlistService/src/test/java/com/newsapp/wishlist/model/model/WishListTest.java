package com.newsapp.wishlist.model.model;


import com.newsapp.wishlist.model.WishList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WishListTest {

    @Test
    public void testCreateWishListSuccess() {
        // Arrange
        WishList wishList = new WishList();
        wishList.setUserId("testUser");
        wishList.setAuthor("Test Author");
        wishList.setTitle("Test Title");
        wishList.setDescription("Test Description");
        wishList.setUrl("https://example.com");
        wishList.setUrlToImage("https://example.com/image.jpg");
        wishList.setPublishedAt("2023-12-05");
        wishList.setContent("Test Content");

        // Act
        assertNotNull(wishList);

        // Assert
        assertEquals("testUser", wishList.getUserId());
        assertEquals("Test Author", wishList.getAuthor());
        assertEquals("Test Title", wishList.getTitle());
        assertEquals("Test Description", wishList.getDescription());
        assertEquals("https://example.com", wishList.getUrl());
        assertEquals("https://example.com/image.jpg", wishList.getUrlToImage());
        assertEquals("2023-12-05", wishList.getPublishedAt());
        assertEquals("Test Content", wishList.getContent());
    }


    @Test
    public void testCreateWishListFailure() {
        // Arrange
        WishList wishList = new WishList();

        // Act
        assertNotNull(wishList);

        // Assert
        assertNull(wishList.getUserId());
        assertNull(wishList.getAuthor());
        assertNull(wishList.getTitle());
        assertNull(wishList.getDescription());
        assertNull(wishList.getUrl());
        assertNull(wishList.getUrlToImage());
        assertNull(wishList.getPublishedAt());
        assertNull(wishList.getContent());
    }
}
