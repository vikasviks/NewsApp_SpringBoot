package com.newsapp.wishlist.model;

import jakarta.persistence.Embeddable;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Source {

    private String id;
    private String name;

    // Other fields if needed
}
