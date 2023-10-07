package com.HotelManagement.mapper;

import com.HotelManagement.dto.LunchItemDTO;
import com.HotelManagement.modal.LunchItem;
import org.springframework.stereotype.Component;

@Component
public class LunchItemMapper {
    LunchItem dtoToEntity(LunchItemDTO lunchItemDTO){

        LunchItem lunchItem = new LunchItem();

        lunchItem.setName(lunchItemDTO.getName());
        lunchItem.setLunchCategory(lunchItemDTO.getLunchCategory());
        lunchItem.setPrice(lunchItemDTO.getPrice());
        lunchItem.setDescription(lunchItemDTO.getDescription());

        return  lunchItem;
    }

    LunchItemDTO entityToDTO(LunchItem lunchItem){

        LunchItemDTO lunchItemDTO = new LunchItemDTO();

        lunchItemDTO.setName(lunchItemDTO.getName());
        lunchItemDTO.setLunchCategory(lunchItemDTO.getLunchCategory());
        lunchItemDTO.setPrice(lunchItemDTO.getPrice());
        lunchItemDTO.setDescription(lunchItemDTO.getDescription());

        return  lunchItemDTO;
    }

}
