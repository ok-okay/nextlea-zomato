package com.example.zomato.restaurant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private byte rating;
    private long time;
    @NotNull(message = "review field cannot be null")
    private String review = "";
    private long helpfulCount;
    private boolean fakeReview;
    @Enumerated(EnumType.STRING)
    private ServiceChannelEnum serviceChannelEnum;
    @ManyToOne
    @JoinColumn(name="user_id")
    @NotNull(message = "user_id field may not be null")
    private UserEntity user;
    @OneToMany(mappedBy = "review")
    private Set<ContentEntity> contentEntitySet;
    @ManyToOne
    @JoinColumn(name="restaurant_id")
    @NotNull(message = "restaurant_id field may not be null")
    private RestaurantEntity restaurant;
    private boolean display;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
