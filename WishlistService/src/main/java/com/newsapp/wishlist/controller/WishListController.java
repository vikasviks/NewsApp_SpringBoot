package com.newsapp.wishlist.controller;

import com.newsapp.wishlist.exception.InvalidTokenException;
import com.newsapp.wishlist.exception.NewsArticleAlreadyExists;
import com.newsapp.wishlist.exception.NewsArticleNotFound;
import com.newsapp.wishlist.exception.UserNotFoundException;
import com.newsapp.wishlist.model.WishList;
import com.newsapp.wishlist.security.JWTTokenValidator;
import com.newsapp.wishlist.service.WishListService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@SecurityRequirement(name = "Bearer Authentication")
@RestController
@RequestMapping("/api/v4/")
public class WishListController {

    private final WishListService wishListService;
    private final JWTTokenValidator jwtTokenValidator;
    ResponseEntity<?> responseEntity;

    @Autowired
    public WishListController(WishListService wishListService, JWTTokenValidator jwtTokenValidator) {
        this.wishListService = wishListService;
        this.jwtTokenValidator = jwtTokenValidator;
    }

    @PostMapping("addFavNews")
    public ResponseEntity<WishList> saveNews(
            @Parameter(hidden = true) @RequestHeader("Authorization") String token,
            @RequestBody WishList wishList) throws NewsArticleAlreadyExists, InvalidTokenException {
        validateToken(token);
        // Extract user ID from the JWT token
        String userId = jwtTokenValidator.extractUserIdFromToken(token);
        System.out.println("UserID%%%%"+ userId);
        // Set the user ID in the WishList object
        wishList.setUserId(userId);
        try {
            responseEntity = new ResponseEntity<>(wishListService.saveNews(wishList), HttpStatus.CREATED);
        } catch (NewsArticleAlreadyExists ex) {
            throw new NewsArticleAlreadyExists(ex.getCustomMessage());
        }
        return (ResponseEntity<WishList>) responseEntity;
    }

    @GetMapping("getFavNewsById/{id}")
    public ResponseEntity<WishList> getFavNewsById(
            @Parameter(hidden = true) @RequestHeader("Authorization") String token, @PathVariable("id") int id)
            throws NewsArticleNotFound, InvalidTokenException {
        validateToken(token);
        try {
            responseEntity = new ResponseEntity<>(wishListService.getNewsById(id), HttpStatus.OK);
        } catch (NewsArticleNotFound ex) {
            throw new NewsArticleNotFound(ex.getCustomMessage());
        }
        return (ResponseEntity<WishList>) responseEntity;
    }

    @GetMapping("GetAllFavNews")
    public ResponseEntity<List<WishList>> getAllFavNews(
            @Parameter(hidden = true) @RequestHeader("Authorization") String token) throws InvalidTokenException {
        validateToken(token);
        return new ResponseEntity<>(wishListService.getAllNews(), HttpStatus.OK);
    }

    @GetMapping("getFavNewsByUser/{userId}")
    public ResponseEntity<List<WishList>> getFavNewsByUserId(
            @Parameter(hidden = true) @RequestHeader("Authorization") String token, @PathVariable("userId") String userId)
            throws NewsArticleNotFound, InvalidTokenException, UserNotFoundException {
        validateToken(token);
        try {
            responseEntity = new ResponseEntity<>(wishListService.getNewsByUser(userId), HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            throw new UserNotFoundException(ex.getCustomMessage());
        }
        return (ResponseEntity<List<WishList>>) responseEntity;
    }

    @DeleteMapping("/deleteNews/{id}")
    public ResponseEntity<String> deleteNewsById(@Parameter(hidden = true) @RequestHeader("Authorization") String token, @PathVariable("id") int id)
            throws NewsArticleNotFound, InvalidTokenException {
        validateToken(token);
        try {
            wishListService.deleteFavNews(id);
            //sending entity as json so http client issue will not occur in frontend
            return ResponseEntity.ok().body("{\"message\": \"News Has been Deleted from Wishlist\"}");
        } catch (NewsArticleNotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + ex.getCustomMessage() + "\"}");
        }
    }

    private void validateToken(String token) throws InvalidTokenException {
        if (token == null || !token.startsWith("Bearer ")) {
            throw new InvalidTokenException("Missing or Invalid Token");
        }

        // Validate the JWT token
        Map<String, String> validationMap = jwtTokenValidator.validateToken(token.substring(7)); // Remove "Bearer " prefix

        // Check if the token is valid
        if (validationMap.containsKey("error")) {
            throw new InvalidTokenException("Invalid Token");
        }
    }
}
