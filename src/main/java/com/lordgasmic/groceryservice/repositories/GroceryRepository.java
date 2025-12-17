package com.lordgasmic.groceryservice.repositories;

import com.lordgasmic.groceryservice.entities.GroceryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryRepository extends CrudRepository<GroceryEntity, Long> {

}
