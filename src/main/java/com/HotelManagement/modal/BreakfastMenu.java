package com.HotelManagement.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Breakfast_Menu")
public class BreakfastMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long category_id;

    @Column(unique = true)
    private String  categoryName;

    @OneToMany(mappedBy = "breakfastMenu",cascade = CascadeType.ALL)
    @Column(nullable = true)
    @JsonBackReference
    private List<MenuItem> menuItems;

}