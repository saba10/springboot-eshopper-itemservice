package com.example.itemservice.dao;

import com.example.itemservice.bean.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long > {
}

