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
        // menu item is null then return
        if(menuItem== null){
            return "Error: A breakfast category must have at least one menu item.";
        }
        try{
            BreakfastMenu breakfastMenu =  breakfastMenuRepository.findByCategoryName(categoryName);
            // if breakfast category exists add menu item to it
            if(breakfastMenu!=null){
                menuItem.setBreakfastMenu(breakfastMenu);
                breakfastMenu.getMenuItems().add(menuItem);
                breakfastMenuRepository.save(breakfastMenu);
                return  "New Menu Added Successfully!";
            }
            // if breakfast category does not exist first add the category
            // then add the menu item into the category
            else{
                BreakfastMenu breakfastMenu1 = new BreakfastMenu();
                breakfastMenu1.setCategoryName(categoryName);
                List<MenuItem> menuItemList = new ArrayList<>();
                menuItem.setBreakfastMenu(breakfastMenu1);
                menuItemList.add(menuItem);
                breakfastMenu1.setMenuItems(menuItemList);
                breakfastMenuRepository.save(breakfastMenu1);
                return "New Category has been added successfully !! Menu item also been added";
            }

        }
        catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }
}
