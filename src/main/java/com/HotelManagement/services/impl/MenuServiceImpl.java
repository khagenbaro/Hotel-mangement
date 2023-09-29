package com.HotelManagement.services.impl;

import com.HotelManagement.modal.BreakfastMenu;
import com.HotelManagement.modal.MenuItem;
import com.HotelManagement.repository.BreakfastMenuRepository;
import com.HotelManagement.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private BreakfastMenuRepository breakfastMenuRepository;
    @Override
    public String addBreakfastMenu(String categoryName , List<MenuItem> menuItem) {
        try{
            BreakfastMenu  breakfastMenu = new BreakfastMenu();
            breakfastMenu.setMenuItems(menuItem);
            breakfastMenuRepository.save(breakfastMenu);
            return  "Added Successfully!";
        }
        catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }
}
