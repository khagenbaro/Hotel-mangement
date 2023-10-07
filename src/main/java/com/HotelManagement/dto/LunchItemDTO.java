package com.HotelManagement.dto;

import com.HotelManagement.modal.LunchCategory;
import lombok.Data;

@Data
public class LunchItemDTO {
    private String name;
    private String description;
    private double price;
    private LunchCategory lunchCategory;
}
