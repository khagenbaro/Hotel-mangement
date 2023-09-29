package com.HotelManagement.services;

import com.HotelManagement.modal.MenuItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
    String addBreakfastMenu(String categoryName , List<MenuItem> menuItems);
}
