package com.HotelManagement.Controller;

import com.HotelManagement.modal.MenuItem;
import com.HotelManagement.services.BreakfastMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/breakfast_menu")
public class BreakfastController {

    @Autowired
    private BreakfastMenuService breakfastMenuService;
//    TO add new category or new menu item s
    @PostMapping(value = "/addBreakfast/ItemORMenu")
    public ResponseEntity<String> addMenuItem(@RequestParam  String categoryName, @RequestBody MenuItem menuItems){
        return ResponseEntity.ok(breakfastMenuService.addBreakfastMenu(categoryName , menuItems));
    }
    @DeleteMapping("/deletemenuitem")
    public ResponseEntity<String> deleteMenuItem(@RequestParam long id){
        return ResponseEntity.ok(breakfastMenuService.deleteBreakfastMenu(id));
    }
    @PutMapping("/updatemenuitem")
    public ResponseEntity<MenuItem> updateMenuItem(@RequestParam long id , @RequestBody MenuItem menuItem){
        return ResponseEntity.ok(breakfastMenuService.updateMenuItem(id, menuItem));
    }


//    @PostMapping(value = "/addBreakfastCategory")
//    public ResponseEntity<String> addBreakfastCategory(@RequestParam String categoryName , @RequestBody MenuItem menuItem){
//        return  ResponseEntity.ok(menuService.addBreakfastCategory(categoryName, menuItem));
//
//    }

}
