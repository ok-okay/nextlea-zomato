package com.example.zomato.restaurant.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "dietary_options")
public class DietaryOptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "dietaryOptionEnum field may not be empty")
    private DietaryOptionEnum dietaryOptionEnum;
    @ManyToOne
    @JoinColumn(name="restaurant_id")
    @Nullable
    private RestaurantEntity restaurant;

    @ManyToOne
    @JoinColumn(name = "food_id")
    @Nullable
    private FoodEntity food;
}
