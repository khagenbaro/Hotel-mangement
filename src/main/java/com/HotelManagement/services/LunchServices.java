package com.HotelManagement.services;

import com.HotelManagement.dto.LunchCategoryDTO;
import com.HotelManagement.dto.LunchMenuDTO;
import org.springframework.stereotype.Service;

@Service
public interface LunchServices {
    String addLunchMenu(LunchMenuDTO lunchMenuDTO);

    String updateLunchMenu(long id, LunchMenuDTO lunchMenuDTO);

    LunchCategoryDTO addLunchCategory();

}
