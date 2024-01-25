package com.newsapp.wishlist.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishlistId;

    private String userId;

    @Embedded
    private Source source;

    private String author;
    private String title;

    @Column(length = 1000)
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    // Other fields if needed
}