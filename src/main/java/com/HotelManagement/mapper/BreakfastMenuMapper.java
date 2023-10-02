package com.HotelManagement.mapper;

import com.HotelManagement.dto.BreakfastMenuDTO;
import com.HotelManagement.modal.BreakfastMenu;
import org.springframework.stereotype.Component;

@Component
public class BreakfastMenuMapper {
    BreakfastMenu dtoToEntity(BreakfastMenuDTO breakfastMenuDTO){
       BreakfastMenu breakfastMenu = new BreakfastMenu();
       //set entity
       breakfastMenu.setCategoryName(breakfastMenuDTO.getCategoryName());
       breakfastMenu.setMenuItems(breakfastMenuDTO.getMenuItems());

       return  breakfastMenu;
    }
    BreakfastMenuDTO entityToDto(BreakfastMenu breakfastMenu){
        BreakfastMenuDTO breakfastMenuDTO = new BreakfastMenuDTO();
        // set dto
        breakfastMenuDTO.setCategoryName(breakfastMenu.getCategoryName());
        breakfastMenuDTO.setMenuItems(breakfastMenu.getMenuItems());

        return breakfastMenuDTO;
    }
}
