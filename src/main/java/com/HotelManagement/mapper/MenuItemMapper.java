package com.HotelManagement.mapper;

import com.HotelManagement.dto.MenuItemDTO;
import com.HotelManagement.modal.BreakfastMenu;
import com.HotelManagement.modal.MenuItem;


public class MenuItemMapper {
    MenuItem dtoToEntity(MenuItemDTO menuItemDTO){
        MenuItem menuItem = new MenuItem();
        //set entity
        menuItem.setItemName(menuItemDTO.getItemName());
        menuItem.setPrice(menuItemDTO.getPrice());
        menuItem.setDescription(menuItemDTO.getDescription());
        //fetch breakfast  category and then fetch the breakfast by the category
        menuItemDTO.getBreakfastCategory();
        //
        BreakfastMenu breakfastMenu = new BreakfastMenu();

        return  menuItem;
    }
}
