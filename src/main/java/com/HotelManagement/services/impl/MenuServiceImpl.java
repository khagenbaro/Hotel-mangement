package com.HotelManagement.services.impl;

import com.HotelManagement.modal.BreakfastMenu;
import com.HotelManagement.modal.MenuItem;
import com.HotelManagement.repository.BreakfastMenuRepository;
import com.HotelManagement.repository.MenuRepository;
import com.HotelManagement.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private BreakfastMenuRepository breakfastMenuRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Override
    public String addBreakfastMenu(String categoryName ,MenuItem menuItem) {
        try{
            BreakfastMenu breakfastMenu =  breakfastMenuRepository.findByCategoryName(categoryName);
            if(breakfastMenu!=null){
                menuItem.setBreakfastMenu(breakfastMenu);
                breakfastMenu.getMenuItems().add(menuItem);
                breakfastMenuRepository.save(breakfastMenu);
                return  "New Menu Added Successfully!";
            }
            else{
                BreakfastMenu breakfastMenu1 = new BreakfastMenu();
                breakfastMenu1.setCategoryName(categoryName);
                List<MenuItem> menuItemList = new ArrayList<>();
                menuItem.setBreakfastMenu(breakfastMenu);
                menuItemList.add(menuItem);
                breakfastMenu1.setMenuItems(menuItemList);
                breakfastMenuRepository.save(breakfastMenu1);
                return "New Category has been added successfully !! ";
            }

        }
        catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }
}
