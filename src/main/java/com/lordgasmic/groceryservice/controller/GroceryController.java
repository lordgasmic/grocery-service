package com.lordgasmic.groceryservice.controller;

import com.lordgasmic.groceryservice.models.GroceryAddRequest;
import com.lordgasmic.groceryservice.models.GroceryListResponse;
import com.lordgasmic.groceryservice.service.GroceryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroceryController {

    private final GroceryService groceryService;

    public GroceryController(final GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @PutMapping("/api/v1/groceries")
    public ResponseEntity<Void> addGroceryItem(@RequestBody final GroceryAddRequest request) {
        groceryService.addGroceryItem(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/api/v1/groceries")
    public ResponseEntity<List<GroceryListResponse>> groceryList() {
        return ResponseEntity.ok(groceryService.generateGroceryList());
    }

    @PostMapping("/api/v1/groceries")
    public ResponseEntity<Void> printGroceryList() {
        groceryService.printGroceryList();
        return ResponseEntity.accepted().build();
    }
}
