package com.HotelManagement.Controller;

import com.HotelManagement.modal.MenuItem;
import com.HotelManagement.services.BreakfastMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breakfast_menu")
public class BreakfastController {

    @Autowired
    private BreakfastMenuService breakfastMenuService;
//    TO add new category or new menu item s
    @PostMapping(value = "/addBreakfast/ItemMenu")
    public ResponseEntity<String> addMenuItem(@RequestParam  String categoryName, @RequestBody MenuItem menuItem){
        return ResponseEntity.ok(breakfastMenuService.addBreakfastMenu(categoryName , menuItem));
    }
    @DeleteMapping("/deletemenuitem")
    public ResponseEntity<String> deleteMenuItem(@RequestParam long id){
        return ResponseEntity.ok(breakfastMenuService.deleteBreakfastMenu(id));
    }
    @PutMapping("/updatemenuitem")
    public ResponseEntity<MenuItem> updateMenuItem(@RequestParam long id , @RequestBody MenuItem menuItem){
        return ResponseEntity.ok(breakfastMenuService.updateMenuItem(id, menuItem));
    }
    @GetMapping("/getAllBreakfastMenu")
    public ResponseEntity<List<MenuItem>>  getAllBreakfastMenu(){
        return ResponseEntity.ok(breakfastMenuService.getAllBreakfastMenu());

    }

//    @PostMapping(value = "/addBreakfastCategory")
//    public ResponseEntity<String> addBreakfastCategory(@RequestParam String categoryName , @RequestBody MenuItem menuItem){
//        return  ResponseEntity.ok(menuService.addBreakfastCategory(categoryName, menuItem));
//
//    }

}
