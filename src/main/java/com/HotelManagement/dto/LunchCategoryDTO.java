package com.HotelManagement.dto;

import com.HotelManagement.modal.LunchItem;
import com.HotelManagement.modal.LunchMenu;
import lombok.Data;

import java.util.List;

@Data
public class LunchCategoryDTO{
    private String name;

    private String description;

    private List<LunchItemDTO> lunchItemList;

}
