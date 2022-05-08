package com.example.itemservice.controller;

import com.example.itemservice.bean.Item;
import com.example.itemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/items")
public class ItemserviceController {

    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "hello world";
    }

    @Autowired
    ItemService itemService;

    /*@Autowired
    List<Item> items;*/

    @GetMapping(path="/getItemById/{id}")
    public List<Item> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        List<Item> items = new ArrayList<>();
        items.add(item);
        return items;
    }

    @GetMapping(path="/getItems")
    public List<Item> getItems() {
        List<Item> items = itemService.getItems();
        return items;
    }

    @GetMapping(path="/deleteById/{id}")
    public List<Item> deleteById(@PathVariable Long id) {
        String status = itemService.deleteById(id);
        List<Item> items = itemService.getItems();
        return items;
    }

    @PostMapping(path="/createItem")
    //@RequestBody and @RequestParam are used by post methods. @PathVariable for get method.
    public Item createItem(@RequestBody Item item){
        return itemService.createItem(item);

    }
}
