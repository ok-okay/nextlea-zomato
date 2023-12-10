package com.example.zomato.restaurant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "content")
public class ContentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "name field may not be empty")
    private String name;
    @NotNull(message = "link field may not be empty")
    private String link;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "contentTagEnum field may not be empty")
    private ContentTagEnum contentTagEnum;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "contentTypeEnum field may not be empty")
    private ContentTypeEnum contentTypeEnum;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "serviceChannelEnum field may not be empty")
    private ServiceChannelEnum serviceChannelEnum;
    @ManyToOne
    @JoinColumn(name="restaurant_id")
    @NotNull(message = "restaurant_id field may not be null")
    private RestaurantEntity restaurant;
    @ManyToOne
    @JoinColumn(name="review_id")
    @NotNull(message = "review_id field may not be null")
    private ReviewEntity review;
    @ManyToOne
    @JoinColumn(name="menu_id")
    @NotNull(message = "menu_id field may not be null")
    private MenuEntity menu;
    @OneToOne
    @JoinColumn(name = "food_id")
    private FoodEntity food;
}
