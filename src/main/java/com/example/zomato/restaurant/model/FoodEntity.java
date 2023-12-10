package com.example.zomato.restaurant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "food")
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private long price;
    @OneToMany(mappedBy = "food")
    private Set<DietaryOptionEntity> dietaryOptionEntities;
    @OneToOne(mappedBy = "food", cascade = CascadeType.ALL)
    private ContentEntity contentEntity;
    @OneToMany(mappedBy = "foodPrimary")
    private Set<FoodTagEntity> foodPrimaryTagEntitySet;
    @OneToMany(mappedBy = "foodSecondary")
    private Set<FoodTagEntity> foodSecondaryTagEntitySet;
    @OneToMany(mappedBy = "food")
    @NotNull(message = "availability_id field may not be null")
    private Set<AvailabilityEntity> availabilityEntity;
    private long closedTill;
    @NotNull(message = "closed_reason cannot be null")
    private String closedReason = "Item unavailable owing to high demand. We'll be back soon!";
    private boolean isActive;
    public String getClosedReason() {
        return closedReason;
    }

    public void setClosedReason(String closedReason) {
        this.closedReason = closedReason;
    }
}
