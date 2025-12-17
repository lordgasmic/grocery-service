package com.lordgasmic.groceryservice.mappers;

import com.lordgasmic.groceryservice.entities.GroceryEntity;
import com.lordgasmic.groceryservice.models.GroceryAddRequest;

public final class GroceryMapper {

    public static GroceryEntity convertToEntity(GroceryAddRequest request) {
        GroceryEntity entity = new GroceryEntity();
        entity.setDepartment(request.getDepartment());
        entity.setQuantity(request.getQuantity());
        entity.setItem(request.getItem());
        return entity;
    }
}
