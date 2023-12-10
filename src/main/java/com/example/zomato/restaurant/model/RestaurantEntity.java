package com.example.zomato.restaurant.model;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "restaurants")
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "name field may not be null")
    private String name;
    private long costForOne;
    private long costForTwo;
    @OneToMany(mappedBy = "restaurant")
    @NotNull(message = "contentEntitySet field may not be null")
    private Set<ContentEntity> contentEntitySet;
    @OneToMany(mappedBy = "restaurant")
    @NotNull(message = "cuisineEntitySet field may not be null")
    private Set<CuisineEntity> cuisineEntitySet;
    @OneToMany(mappedBy = "restaurant")
    @NotNull(message = "dietaryOptionEntitySet field may not be null")
    private Set<DietaryOptionEntity> dietaryOptionEntitySet;
    @OneToMany(mappedBy = "restaurant")
    @Nullable
    private Set<ReviewEntity> reviewEntitySet;
    @OneToMany(mappedBy = "restaurant")
    @Nullable
    private Set<SponsorEntity> sponsorEntitySet;
    @ManyToMany(mappedBy="restaurantEntitySet")
    private Set<PromoEntity> promoEntitySet;
    private boolean isPromoted;
    @OneToMany(mappedBy = "restaurant")
    @NotNull(message = "openingHoursEntitySet field may not be null")
    private Set<AvailabilityEntity> availabilityEntitySet;
    private long closedTill;
    @NotNull(message = "closed_reason cannot be null")
    private String closedReason = "Restaurant closed temporarily owing to high demand. We'll be back soon!";
    private boolean isActive;
    public String getClosedReason() {
        return closedReason;
    }

    public void setClosedReason(String closedReason) {
        this.closedReason = closedReason;
    }
}
