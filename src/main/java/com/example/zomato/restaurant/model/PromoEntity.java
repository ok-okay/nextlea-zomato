package com.example.zomato.restaurant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "promos")
public class PromoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "name field may not be null")
    private String name;
    private String code;
    private long expiry;
    @Enumerated(EnumType.STRING)
    private PromoTypeEnum promoTypeEnum;
    @ManyToMany
    @JoinTable(
            name="promos_conditions",
            joinColumns= @JoinColumn(name="condition_id"),
            inverseJoinColumns= @JoinColumn(name="promo_id")
    )
    private Set<ConditionsEntity> conditionsEntitySet;

    @ManyToMany
    @JoinTable(
            name="promos_restaurants",
            joinColumns= @JoinColumn(name="restaurant"),
            inverseJoinColumns= @JoinColumn(name="promo_id")
    )
    private Set<RestaurantEntity> restaurantEntitySet;
}
