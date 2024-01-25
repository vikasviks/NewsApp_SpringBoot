package com.newsapp.news.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class News {

    private String status;
    private int totalResults;
    private List<Article> articles;
}
