package com.example.zomato.restaurant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "menu")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "name field may not be null")
    private String name;

    @OneToMany(mappedBy = "menu")
    @NotNull(message = "contentEntitySet field may not be null")
    private Set<ContentEntity> contentEntitySet;
}
