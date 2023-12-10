package com.example.zomato.restaurant.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "opening_hours")
public class AvailabilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private byte dayOfWeek;
    @ManyToOne
    @JoinColumn(name="restaurant_id")
    @NotNull(message = "restaurant_id field may not be null")
    private RestaurantEntity restaurant;
    @ManyToOne
    @JoinColumn(name="food_id")
    @Nullable
    private FoodEntity food;
    private long openingTimeInSec;
    private long closingTimeInSec;
}
