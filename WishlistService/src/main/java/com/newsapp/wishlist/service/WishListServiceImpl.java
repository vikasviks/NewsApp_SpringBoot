package com.newsapp.wishlist.service;


import com.newsapp.wishlist.exception.NewsArticleAlreadyExists;
import com.newsapp.wishlist.exception.NewsArticleNotFound;
import com.newsapp.wishlist.exception.UserNotFoundException;
import com.newsapp.wishlist.model.WishList;
import com.newsapp.wishlist.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishListServiceImpl implements WishListService{

    private final WishlistRepository wishlistRepository;

    @Autowired
    public WishListServiceImpl(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public WishList saveNews(WishList wishList) throws NewsArticleAlreadyExists {

        // Fetch all wishlists for the user
        List<WishList> byUserId = wishlistRepository.findByUserId(wishList.getUserId());

        // Check if the wishlist already contains the news article
        boolean newsArticleExists = byUserId.stream()
                .anyMatch(existingWishList -> existingWishList.getUrl().equals(wishList.getUrl()));

        if (newsArticleExists) {
            throw new NewsArticleAlreadyExists("News Article Already Exists in the Wishlist!!");
        }

//        WishList byUrl = wishlistRepository.findByUrl(wishList.getUrl());
//        if(byUrl!=null)
//        {
//            throw new NewsArticleAlreadyExists("News Article Already Exists!!");
//        }

        return wishlistRepository.save(wishList);
    }

    @Override
    public WishList getNewsById(int id) throws NewsArticleNotFound {
        Optional<WishList> byId = wishlistRepository.findById(id);
        if (byId.isPresent()) {
            return wishlistRepository.findById(id).get();
        }
        throw new NewsArticleNotFound("News Article with ID " + id + " Not Found!!");
    }


    @Override
    public List<WishList> getAllNews() {
        return wishlistRepository.findAll();
    }

    @Override
    public String deleteFavNews(int id) throws NewsArticleNotFound {
        Optional<WishList> byId = wishlistRepository.findById(id);
        if(byId.isPresent()) {
            wishlistRepository.deleteById(id);
            return "News Has been Deleted from Wishlist";
        }
        throw new NewsArticleNotFound("News Article with ID " + id + " Not Found!!");
    }

    @Override
    public List<WishList> getNewsByUser(String userId) throws UserNotFoundException {
        List<WishList> byUserId = wishlistRepository.findByUserId(userId);
        if(byUserId!=null){
            return byUserId;
        }
        throw new UserNotFoundException("User with ID " + userId + " Not Found on the server!!");
    }
}
