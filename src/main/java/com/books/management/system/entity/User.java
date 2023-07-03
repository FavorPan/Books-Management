package com.books.management.system.entity;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;
}
