package com.HotelManagement.mapper;

import com.HotelManagement.dto.LunchItemDTO;
import com.HotelManagement.modal.LunchItem;
import org.springframework.stereotype.Component;

@Component
public class LunchItemMapper {
    public  LunchItemDTO toDTO(LunchItem lunchItem) {
        LunchItemDTO dto = new LunchItemDTO();
        dto.setName(lunchItem.getName());
        dto.setDescription(lunchItem.getDescription());
        dto.setPrice(lunchItem.getPrice());
        return dto;
    }

    public  LunchItem toEntity(LunchItemDTO dto) {
        LunchItem lunchItem = new LunchItem();
        lunchItem.setName(dto.getName());
        lunchItem.setDescription(dto.getDescription());
        lunchItem.setPrice(dto.getPrice());
        return lunchItem;
    }

}
