package com.lordgasmic.groceryservice.service;

import com.lordgasmic.groceryservice.mappers.GroceryMapper;
import com.lordgasmic.groceryservice.models.GroceryAddRequest;
import com.lordgasmic.groceryservice.repositories.GroceryRepository;
import org.springframework.stereotype.Service;

@Service
public class GroceryService {

    private final GroceryRepository groceryRepository;

    public GroceryService(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    public void addGroceryItem(GroceryAddRequest item) {
        groceryRepository.save(GroceryMapper.convertToEntity(item));
    }

    public void generateGroceryList() {
        groceryRepository.generateGroceryList();
    }
}
