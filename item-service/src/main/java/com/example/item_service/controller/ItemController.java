package com.example.item_service.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {
    @GetMapping("/getItem")
    public String getItem() {
        return "Item Service is working";
    }
    @PostMapping("/saveItem")
    public Object saveItem(@RequestBody Object item){
        System.out.println("item"+item);
        return item;
    }

}
