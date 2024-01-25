package com.newsapp.wishlist.exception;

public class NewsArticleAlreadyExists extends Exception{

    private final String customMessage;

    public NewsArticleAlreadyExists(String customMessage) {
        super(customMessage);
        this.customMessage = customMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }
}
