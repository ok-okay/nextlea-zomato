package com.example.zomato.restaurant.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "conditions")
public class ConditionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String condition;
    @Enumerated(EnumType.STRING)
    private ConditionTypeEnum conditionTypeEnum;
    @ManyToMany(mappedBy="conditionsEntitySet")
    private Set<PromoEntity> promoEntitySet;
}
