package com.HotelManagement.services.impl;

import com.HotelManagement.dto.LunchCategoryDTO;
import com.HotelManagement.dto.LunchItemDTO;
import com.HotelManagement.dto.LunchMenuDTO;
import com.HotelManagement.modal.LunchCategory;
import com.HotelManagement.modal.LunchItem;
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
            List<LunchCategory> lunchCategories = new ArrayList<>();

            for (LunchCategory category : lunchMenuDTO.getLunchCategoryList()) {
                LunchCategory lunchCategory = new LunchCategory();
                lunchCategory.setName(category.getName());
                lunchCategory.setDescription(category.getDescription());

                List<LunchItem> lunchItems = new ArrayList<>();

                for (LunchItem item : category.getLunchItemList()) {
                    LunchItem lunchItem = new LunchItem();
                    lunchItem.setName(item.getName());
                    lunchItem.setDescription(item.getDescription());
                    lunchItem.setPrice(item.getPrice());
                    // Set the LunchItem's LunchCategory
                    lunchItem.setLunchCategory(lunchCategory);
                    lunchItems.add(lunchItem);
                }

                // Set the LunchCategory's LunchItems
                lunchCategory.setLunchItemList(lunchItems);
                // Set the LunchCategory's LunchMenu
                lunchCategory.setLunchMenu(lunchMenu);
                lunchCategories.add(lunchCategory);
            }

            // Set the LunchMenu's LunchCategories
            lunchMenu.setLunchCategoryList(lunchCategories);

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
