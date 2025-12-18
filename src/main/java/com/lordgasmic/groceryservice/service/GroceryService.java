package com.lordgasmic.groceryservice.service;

import com.lordgasmic.groceryservice.entities.GroceryEntity;
import com.lordgasmic.groceryservice.mappers.GroceryMapper;
import com.lordgasmic.groceryservice.models.GroceryAddRequest;
import com.lordgasmic.groceryservice.models.GroceryListPayload;
import com.lordgasmic.groceryservice.models.GroceryListResponse;
import com.lordgasmic.groceryservice.models.Item;
import com.lordgasmic.groceryservice.repositories.GroceryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroceryService {

    private final GroceryRepository groceryRepository;
    private final PrintConnector printConnector;

    public GroceryService(final GroceryRepository groceryRepository, final PrintConnector printConnector) {
        this.groceryRepository = groceryRepository;
        this.printConnector = printConnector;
    }

    public void addGroceryItem(final GroceryAddRequest item) {
        groceryRepository.save(GroceryMapper.convertToEntity(item));
    }

    public List<GroceryListResponse> generateGroceryList() {
        final Iterable<GroceryEntity> entities = groceryRepository.findAll();

        final List<GroceryListResponse> responses = new ArrayList<>();
        for (final GroceryEntity entity : entities) {
            responses.add(GroceryMapper.convertToListResponse(entity));
        }

        return responses;
    }

    public void printGroceryList() {
        final List<GroceryListResponse> responses = generateGroceryList();

        final Map<String, List<Item>> groupedGroceries = new HashMap<>();
        for (final GroceryListResponse response : responses) {
            List<Item> list = groupedGroceries.get(response.getDepartment());
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(new Item(response.getQuantity(), response.getItem()));
            groupedGroceries.put(response.getDepartment(), list);
        }

        printConnector.send(GroceryListPayload.builder().type("GROCERY_LIST").groceryList(groupedGroceries).build());

        groceryRepository.deleteAll();
    }
}
