package com.lordgasmic.groceryservice.mappers;

import com.lordgasmic.groceryservice.entities.GroceryEntity;
import com.lordgasmic.groceryservice.models.GroceryAddRequest;
import com.lordgasmic.groceryservice.models.GroceryListResponse;

public final class GroceryMapper {

    public static GroceryEntity convertToEntity(final GroceryAddRequest request) {
        final GroceryEntity entity = new GroceryEntity();
        entity.setId(request.getId());
        entity.setDepartment(request.getDepartment());
        entity.setQuantity(request.getQuantity());
        entity.setItem(request.getItem());
        return entity;
    }

    public static GroceryListResponse convertToListResponse(final GroceryEntity entity) {
        final GroceryListResponse response = new GroceryListResponse();
        response.setId(entity.getId());
        response.setDepartment(entity.getDepartment());
        response.setQuantity(entity.getQuantity());
        response.setItem(entity.getItem());
        return response;
    }
}
