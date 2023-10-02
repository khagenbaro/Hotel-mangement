package com.HotelManagement.services;

import com.HotelManagement.modal.MenuItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BreakfastMenuService {
    String addBreakfastMenu(String categoryName , MenuItem menuItems);

//  String addBreakfastCategory(String categoryName);
    String deleteBreakfastMenu(long id);

    MenuItem updateMenuItem(long id, MenuItem menuItem);

    List<MenuItem> getAllBreakfastMenu();
}