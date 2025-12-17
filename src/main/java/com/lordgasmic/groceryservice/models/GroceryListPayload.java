package com.lordgasmic.groceryservice.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class GroceryListPayload {
    private String type;
    private Map<String, List<Item>> groceryList;
}
