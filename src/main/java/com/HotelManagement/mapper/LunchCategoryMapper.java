package com.HotelManagement.mapper;

import com.HotelManagement.dto.LunchCategoryDTO;
import com.HotelManagement.modal.LunchCategory;
import org.springframework.stereotype.Component;

@Component
public class LunchCategoryMapper {
    LunchCategory dtoToEntity(LunchCategoryDTO lunchCategoryDTO){

        LunchCategory lunchCategory = new LunchCategory();

        lunchCategory.setName(lunchCategoryDTO.getName());
        lunchCategory.setDescription(lunchCategoryDTO.getDescription());
        lunchCategory.setLunchItems(lunchCategoryDTO.getLunchItems());

        return lunchCategory;
    }

    LunchCategoryDTO entityToDTO(LunchCategory lunchCategory){

        LunchCategoryDTO lunchCategoryDTO = new LunchCategoryDTO();

        lunchCategoryDTO.setName(lunchCategoryDTO.getName());
        lunchCategoryDTO.setDescription(lunchCategoryDTO.getDescription());
        lunchCategoryDTO.setLunchItems(lunchCategoryDTO.getLunchItems());

        return lunchCategoryDTO;
    }
}
