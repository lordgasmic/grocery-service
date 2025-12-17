package com.lordgasmic.groceryservice.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class TruncateRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional // Truncate might require transactional context depending on the DB
    public void truncateMyEntityTable() {
        entityManager.createNativeQuery("TRUNCATE TABLE grocery_list_vw").executeUpdate();
    }
}
