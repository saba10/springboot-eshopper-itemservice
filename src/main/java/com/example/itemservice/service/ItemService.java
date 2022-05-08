package com.example.itemservice.service;

import com.example.itemservice.bean.Item;
import com.example.itemservice.dao.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component  -  similar to @Service but use @service for readability
@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item createItem(Item item){
        return itemRepository.save(item);
    }

    public List<Item> createItems(List<Item> items){
        return itemRepository.saveAll(items);
    }

    public Item getItemById(Long id){
        return itemRepository.findById(id).orElse(null);
    }

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public String deleteById(Long id){
        itemRepository.deleteById(id);
        return "deleted";
    }
}
