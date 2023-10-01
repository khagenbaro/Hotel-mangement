package com.HotelManagement.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Menu_Item")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    private String itemName;

    private double price;

    private String description ;

    @ManyToOne()
    @JoinColumn(name="breakfastCategory_id")
    @JsonBackReference
    private BreakfastMenu breakfastMenu;


}
