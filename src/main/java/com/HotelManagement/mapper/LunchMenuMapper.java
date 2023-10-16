package com.HotelManagement.mapper;

import com.HotelManagement.dto.LunchMenuDTO;
import com.HotelManagement.modal.LunchMenu;
import org.springframework.stereotype.Component;

@Component
public class LunchMenuMapper {
    public LunchMenuDTO entityToDto(LunchMenu lunchMenu){
        LunchMenuDTO lunchMenuDTO = new LunchMenuDTO();
        lunchMenuDTO.setName(lunchMenu.getName());
        lunchMenuDTO.setLunchCategoryList(lunchMenu.getLunchCategoryList());
        lunchMenuDTO.setDescription(lunchMenu.getDescription());
        return  lunchMenuDTO;
    }
    public LunchMenu entityToDto(LunchMenuDTO lunchMenuDto){
        LunchMenu lunchMenu = new LunchMenu();
        lunchMenu.setName(lunchMenuDto.getName());
        lunchMenu.setLunchCategoryList(lunchMenuDto.getLunchCategoryList());
        lunchMenu.setDescription(lunchMenuDto.getDescription());
        return  lunchMenu;
    }
}
