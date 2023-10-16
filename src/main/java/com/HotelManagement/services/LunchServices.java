package com.HotelManagement.services;

import com.HotelManagement.dto.LunchCategoryDTO;
import com.HotelManagement.dto.LunchMenuDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LunchServices {
    String addLunchMenu(LunchMenuDTO lunchMenuDTO);

    String updateLunchMenu(long id, LunchMenuDTO lunchMenuDTO);

    String deleteLunchMenu(long id);

    List<LunchMenuDTO> getAllLunchMenu();

    LunchMenuDTO getLunchMenuById(long id);

    LunchCategoryDTO addLunchCategory();

}
