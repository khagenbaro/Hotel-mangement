package com.HotelManagement.mapper;

import com.HotelManagement.dto.MenuItemDTO;
import com.HotelManagement.modal.BreakfastMenu;
import com.HotelManagement.modal.MenuItem;
import com.HotelManagement.repository.BreakfastMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuItemMapper {
    @Autowired
    private BreakfastMenuRepository breakfastMenuRepository;
     public MenuItem dtoToEntity(MenuItemDTO menuItemDTO){
        MenuItem menuItem = new MenuItem();
        //set entity
        menuItem.setItemName(menuItemDTO.getItemName());
        menuItem.setPrice(menuItemDTO.getPrice());
        menuItem.setDescription(menuItemDTO.getDescription());
        //fetch breakfast  category and then fetch the breakfast by the category
        BreakfastMenu breakfastMenu = breakfastMenuRepository.findByCategoryName(menuItemDTO.getBreakfastCategory());
        menuItem.setBreakfastMenu(breakfastMenu);
        return menuItem;
    }
    public MenuItemDTO entityToDTO(MenuItem menuItem){
         MenuItemDTO menuItemDTO = new MenuItemDTO();
         menuItemDTO.setItemName(menuItem.getItemName());
         menuItemDTO.setDescription(menuItem.getDescription());
         menuItemDTO.setPrice(menuItem.getPrice());
         menuItemDTO.setBreakfastCategory(menuItem.getBreakfastMenu().getCategoryName());
         return menuItemDTO;
    }
}
