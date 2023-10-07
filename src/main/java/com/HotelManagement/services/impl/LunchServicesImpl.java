package com.HotelManagement.services.impl;

import com.HotelManagement.dto.LunchCategoryDTO;
import com.HotelManagement.dto.LunchMenuDTO;
import com.HotelManagement.modal.LunchCategory;
import com.HotelManagement.modal.LunchMenu;
import com.HotelManagement.repository.lunch.LunchCategoryRepository;
import com.HotelManagement.repository.lunch.LunchItemRepository;
import com.HotelManagement.repository.lunch.LunchMenuRepository;
import com.HotelManagement.services.LunchServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LunchServicesImpl implements LunchServices {
    @Autowired
    LunchMenuRepository lunchMenuRepository;
    @Autowired
    LunchItemRepository lunchItemRepository;
    @Autowired
    LunchCategoryRepository lunchCategoryRepository;
    @Override
    public String addLunchMenu(LunchMenuDTO lunchMenuDTO) {

        if(lunchMenuDTO==null){
            return "Can not add empty menu";
        }

        LunchMenu lunchMenu = new LunchMenu();
        try{
            lunchMenu.setName(lunchMenuDTO.getName());
            lunchMenu.setDescription(lunchMenuDTO.getDescription());
            lunchMenu.setLunchCategoryList(lunchMenuDTO.getLunchCategoryList());
            lunchMenu.getLunchCategoryList().addAll(lunchMenuDTO.getLunchCategoryList());
            List<LunchCategory> lunchCategoryList = lunchMenu.getLunchCategoryList();

            lunchMenuRepository.save(lunchMenu);
            return "Lunch menu added successfully";
        }
        catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }

    }

    @Override
    public LunchMenuDTO updateLunchMenu(LunchMenuDTO lunchMenuDTO) {
        return null;
    }

    @Override
    public LunchCategoryDTO addLunchCategory() {
        return null;
    }
}
