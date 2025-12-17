package com.lordgasmic.groceryservice.controller;

import com.lordgasmic.groceryservice.models.GroceryAddRequest;
import com.lordgasmic.groceryservice.service.GroceryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroceryController {

    private final GroceryService groceryService;

    public GroceryController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @PutMapping("/api/v1/grocery")
    public ResponseEntity<Void> addGroceryItem(@RequestBody GroceryAddRequest request) {
        groceryService.addGroceryItem(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/api/v1/generate-grocery-list")
    public ResponseEntity<Void> generateGroceryList() {
        groceryService.generateGroceryList();
        return ResponseEntity.accepted().build();
    }
}
