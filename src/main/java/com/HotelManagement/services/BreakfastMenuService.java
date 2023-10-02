package com.HotelManagement.services;

import com.HotelManagement.dto.MenuItemDTO;
import com.HotelManagement.modal.MenuItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BreakfastMenuService {
    String addBreakfastMenu(String categoryName , MenuItemDTO menuItemsDto);

//  String addBreakfastCategory(String categoryName);
    String deleteBreakfastMenu(long id);

    MenuItemDTO updateMenuItem(long id, MenuItemDTO menuItemDto);

    List<MenuItem> getAllBreakfastMenu();
}
