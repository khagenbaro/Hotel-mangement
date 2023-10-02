package com.HotelManagement.dto;


import lombok.Data;

@Data
public class MenuItemDTO {

    private String itemName;

    private double price;

    private String description ;

    private String breakfastCategory;
}
