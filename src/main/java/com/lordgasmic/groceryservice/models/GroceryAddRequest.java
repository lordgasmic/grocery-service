package com.lordgasmic.groceryservice.models;

import lombok.Data;

@Data
public class GroceryAddRequest {
    private String department;
    private String quantity;
    private String item;
}
