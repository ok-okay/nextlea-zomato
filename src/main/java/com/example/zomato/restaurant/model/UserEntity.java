package com.example.zomato.restaurant.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "name field may not be null")
    private String name;
    private long followers;
    @OneToMany(mappedBy = "user")
    @Nullable
    private Set<ReviewEntity> reviewEntitySet;
}
