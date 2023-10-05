package com.HotelManagement.mapper;

import com.HotelManagement.dto.LunchMenuDTO;
import com.HotelManagement.modal.LunchMenu;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

@Component
public class LunchMenuMapper {
    LunchMenuDTO entityToDto(LunchMenu lunchMenu){
        LunchMenuDTO lunchMenuDTO = new LunchMenuDTO();
        lunchMenuDTO.setName(lunchMenu.getName());
        lunchMenuDTO.setLunchCategories(lunchMenu.getLunchCategories());
        lunchMenuDTO.setDescription(lunchMenu.getDescription());
        return  lunchMenuDTO;
    }
    LunchMenu entityToDto(LunchMenuDTO lunchMenuDto){
        LunchMenu lunchMenu = new LunchMenu();
        lunchMenu.setName(lunchMenuDto.getName());
        lunchMenu.setLunchCategories(lunchMenuDto.getLunchCategories());
        lunchMenu.setDescription(lunchMenuDto.getDescription());
        return  lunchMenu;
    }
}
