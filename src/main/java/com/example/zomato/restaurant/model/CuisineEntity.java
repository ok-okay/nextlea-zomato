package com.example.zomato.restaurant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cuisines")
public class CuisineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "cuisineEnum field may not be empty")
    private CuisineEnum cuisineEnum;
    @ManyToOne
    @JoinColumn(name="restaurant_id")
    @NotNull(message = "restaurant_id field may not be null")
    private RestaurantEntity restaurant;
}
