package com.newsapp.auth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {

    @Id
    private String email;
    private String userName;
    private String password;
    private String role;
}
