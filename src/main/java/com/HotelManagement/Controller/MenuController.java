package com.HotelManagement.Controller;

import com.HotelManagement.modal.MenuItem;
import com.HotelManagement.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/breakfast_menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
//    TO add new category or new menu item s
    @PostMapping(value = "/addBreakfast/ItemORMenu")
    public ResponseEntity<String> addMenuItem(@RequestParam  String categoryName, @RequestBody MenuItem menuItems){
        return ResponseEntity.ok(menuService.addBreakfastMenu(categoryName , menuItems));
    }
//    @PostMapping(value = "/addBreakfastCategory")
//    public ResponseEntity<String> addBreakfastCategory(@RequestParam String categoryName , @RequestBody MenuItem menuItem){
//        return  ResponseEntity.ok(menuService.addBreakfastCategory(categoryName, menuItem));
//
//    }

}
