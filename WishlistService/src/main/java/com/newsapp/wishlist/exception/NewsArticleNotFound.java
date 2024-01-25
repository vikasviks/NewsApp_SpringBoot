package com.newsapp.wishlist.exception;

public class NewsArticleNotFound extends Exception{

    private final String customMessage;

    public NewsArticleNotFound(String customMessage) {
        super(customMessage);
        this.customMessage = customMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }
}
