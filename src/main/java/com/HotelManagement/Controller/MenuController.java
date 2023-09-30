package com.HotelManagement.Controller;

import com.HotelManagement.modal.MenuItem;
import com.HotelManagement.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;
    @PostMapping(value = "/addBreakfast")
    public ResponseEntity<String> addMenuItem(@RequestParam  String categoryName, @RequestBody MenuItem menuItems){
        return ResponseEntity.ok(menuService.addBreakfastMenu(categoryName , menuItems));
    }

}
