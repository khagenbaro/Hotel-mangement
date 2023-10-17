package com.HotelManagement.mapper;

import com.HotelManagement.dto.LunchCategoryDTO;
import com.HotelManagement.dto.LunchItemDTO;
import com.HotelManagement.modal.LunchCategory;
import com.HotelManagement.modal.LunchItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LunchCategoryMapper {
    @Autowired
    private LunchItemMapper lunchItemMapper;
    public  LunchCategoryDTO toDTO(LunchCategory lunchCategory) {
        LunchCategoryDTO dto = new LunchCategoryDTO();
        dto.setName(lunchCategory.getName());
        dto.setDescription(lunchCategory.getDescription());
        List<LunchItemDTO> itemDTOs = lunchCategory.getLunchItemList()
                .stream()
                .map(lunchItemMapper::toDTO)
                .collect(Collectors.toList());
        dto.setLunchItemList(itemDTOs);
        return dto;
    }

    public  LunchCategory toEntity(LunchCategoryDTO dto) {
        LunchCategory lunchCategory = new LunchCategory();
        lunchCategory.setName(dto.getName());
        lunchCategory.setDescription(dto.getDescription());
        List<LunchItem> items = dto.getLunchItemList()
                .stream()
                .map(lunchItemMapper::toEntity)
                .collect(Collectors.toList());
        lunchCategory.setLunchItemList(items);
        return lunchCategory;
    }
}
