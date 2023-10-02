package com.HotelManagement.services.impl;

import com.HotelManagement.dto.MenuItemDTO;
import com.HotelManagement.mapper.MenuItemMapper;
import com.HotelManagement.modal.BreakfastMenu;
import com.HotelManagement.modal.MenuItem;
import com.HotelManagement.repository.BreakfastMenuRepository;
import com.HotelManagement.repository.MenuRepository;
import com.HotelManagement.services.BreakfastMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BreakfastMenuServiceImpl implements BreakfastMenuService {
    @Autowired
    private BreakfastMenuRepository breakfastMenuRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuItemMapper menuItemMapper;
    @Override
    public String addBreakfastMenu( MenuItemDTO menuItemDTO) {
        // menu item is null then return
        if(menuItemDTO == null){
            return "Error: A breakfast category must have at least one menu item.";
        }
        try{
            BreakfastMenu breakfastMenu =  breakfastMenuRepository.findByCategoryName(menuItemDTO.getBreakfastCategory());
            MenuItem menuItem = new MenuItem();
            // if breakfast category exists add menu item to it
            if(breakfastMenu!=null){
                List<MenuItem> menuItemList = breakfastMenu.getMenuItems();
                List<String> itemNamesList = new ArrayList<>();
                for(MenuItem item : menuItemList){
                    itemNamesList.add(item.getItemName());
                }
                if(!itemNamesList.contains(menuItemDTO.getItemName())){
                    menuItem.setItemName(menuItemDTO.getItemName());
                    menuItem.setPrice(menuItemDTO.getPrice());
                    menuItem.setDescription(menuItemDTO.getDescription());
                    menuItem.setBreakfastMenu(breakfastMenu);
                    breakfastMenu.getMenuItems().add(menuItem);
                    breakfastMenuRepository.save(breakfastMenu);
                    return  "New Menu Added Successfully!";
                }
                else{
                    return  "Menu Item Already Exists!";
                }
            }
            // if breakfast category does not exist first add the category
            // then add the menu item into the category
            else{
                BreakfastMenu breakfastMenu1 = new BreakfastMenu();
                breakfastMenu1.setCategoryName(menuItemDTO.getBreakfastCategory());
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

    @Override
    public String deleteBreakfastMenu(long id) {
        Optional<MenuItem> menuItemOptional = menuRepository.findById(id);
        if(menuItemOptional.isPresent()){
            menuRepository.deleteById(id);
            return  "Menu Item has been deleted !";
        }
        else {
            return "Menu does not exist with id "+id;
        }
    }

    @Override
    public MenuItemDTO updateMenuItem(long id, MenuItemDTO menuItemDTO) {
        Optional<MenuItem> menuItem = menuRepository.findById(id);
        if(menuItem.isPresent()){
            MenuItem menuItem2 = menuItem.get();
            menuItem2.setItemName(menuItemDTO.getItemName());
            menuItem2.setPrice(menuItemDTO.getPrice());
            menuItem2.setDescription(menuItemDTO.getDescription());
            menuItem2.setBreakfastMenu(menuItem.get().getBreakfastMenu());
            menuRepository.save(menuItem2);
            return menuItemMapper.entityToDTO(menuItem2);
        }else {
            throw new RuntimeException("Something happened");
        }
    }

    @Override
    public List<MenuItemDTO> getAllBreakfastMenu() {
        List<MenuItemDTO>  menuItemDTOList = new ArrayList<>();
        List<MenuItem> menuItemList = menuRepository.findAll();
        if(!menuItemList.isEmpty()){
            for(MenuItem item : menuItemList){
                menuItemDTOList.add(menuItemMapper.entityToDTO(item));
            }
        }
        return menuItemDTOList;
    }
}
