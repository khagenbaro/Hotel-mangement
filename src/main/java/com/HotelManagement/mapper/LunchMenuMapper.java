package com.HotelManagement.mapper;

import com.HotelManagement.dto.LunchCategoryDTO;
import com.HotelManagement.dto.LunchMenuDTO;
import com.HotelManagement.modal.LunchCategory;
import com.HotelManagement.modal.LunchMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LunchMenuMapper {
    @Autowired
    private LunchCategoryMapper lunchCategoryMapper;
    public  LunchMenuDTO toDTO(LunchMenu lunchMenu) {
        LunchMenuDTO dto = new LunchMenuDTO();
        dto.setName(lunchMenu.getName());
        dto.setDescription(lunchMenu.getDescription());
        List<LunchCategoryDTO> categoryDTOs = lunchMenu.getLunchCategoryList()
                .stream()
                .map(lunchCategoryMapper::toDTO)
                .collect(Collectors.toList());
        dto.setLunchCategoryList(categoryDTOs);
        return dto;
    }

    public  LunchMenu toEntity(LunchMenuDTO dto) {
        LunchMenu lunchMenu = new LunchMenu();
        lunchMenu.setName(dto.getName());
        lunchMenu.setDescription(dto.getDescription());
        List<LunchCategory> categories = dto.getLunchCategoryList()
                .stream()
                .map(lunchCategoryMapper::toEntity)
                .collect(Collectors.toList());
        lunchMenu.setLunchCategoryList(categories);
        return lunchMenu;
    }
}
