package com.newsapp.wishlist.repository;


import com.newsapp.wishlist.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<WishList,Integer> {

    public WishList findByUrl(String url);

    public List<WishList> findByUserId(String userId);

}
