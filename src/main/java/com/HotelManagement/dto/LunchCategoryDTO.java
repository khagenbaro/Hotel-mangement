package com.HotelManagement.dto;

import com.HotelManagement.modal.LunchItem;
import lombok.Data;

import java.util.List;

@Data
public class LunchCategoryDTO{
    private String name;
    private String description;
    private List<LunchItem> lunchItems;

}
