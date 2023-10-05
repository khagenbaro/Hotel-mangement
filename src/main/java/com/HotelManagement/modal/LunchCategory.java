package com.HotelManagement.modal;

import jakarta.persistence.*;

import java.util.List;

public class LunchCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<LunchItem> lunchItems;

}
