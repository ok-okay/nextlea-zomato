package com.example.zomato.restaurant.model;

import jakarta.persistence.*;

@Entity
@Table(name = "food_types")
public class FoodTagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private FoodTagEnum foodTagEnum;
    @ManyToOne
    @JoinColumn(name = "primary_tag")
    private FoodEntity foodPrimary;
    @ManyToOne
    @JoinColumn(name = "secondary_tag")
    private FoodEntity foodSecondary;
}
