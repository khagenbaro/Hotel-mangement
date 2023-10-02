package com.HotelManagement.dto;

import com.HotelManagement.modal.MenuItem;
import lombok.Data;

import java.util.List;

@Data
public class BreakfastMenuDTO {
    private String  categoryName;
    private List<MenuItem> menuItems;
}
