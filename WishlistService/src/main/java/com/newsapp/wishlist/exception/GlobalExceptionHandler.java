package com.newsapp.wishlist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", "Error Occurred!!");
        errors.put("message", ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NewsArticleAlreadyExists.class)
    public ResponseEntity<Map<String, String>> handleUserAlreadyExistException(NewsArticleAlreadyExists newsArticleAlreadyExists) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Error while saving News!!");
        errorResponse.put("message", newsArticleAlreadyExists.getCustomMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NewsArticleNotFound.class)
    public ResponseEntity<Map<String, String>> handleUserAlreadyExistException(NewsArticleNotFound newsArticleNotFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Error while getting News from Wishlist!!");
        errorResponse.put("message", newsArticleNotFound.getCustomMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<Map<String, String>> handleJWTTokenException(InvalidTokenException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Error Token is Required for Authentication: Unauthorized!!");
        errorResponse.put("message", "Invalid Token or the Token has been Expired!!");
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotExistException(UserNotFoundException userNotFoundException) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Error while fetching User from Server.!!");
        errorResponse.put("message", userNotFoundException.getCustomMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
