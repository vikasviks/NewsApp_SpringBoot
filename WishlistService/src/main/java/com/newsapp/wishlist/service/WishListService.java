package com.newsapp.wishlist.service;



import com.newsapp.wishlist.exception.NewsArticleAlreadyExists;
import com.newsapp.wishlist.exception.NewsArticleNotFound;
import com.newsapp.wishlist.exception.UserNotFoundException;
import com.newsapp.wishlist.model.WishList;

import java.util.List;

public interface WishListService {

    WishList saveNews(WishList wishList) throws NewsArticleAlreadyExists;

    WishList getNewsById(int id) throws NewsArticleNotFound;
    public List<WishList> getAllNews();

    public String deleteFavNews(int id) throws NewsArticleNotFound;

    public List<WishList> getNewsByUser(String userId) throws UserNotFoundException;
}
