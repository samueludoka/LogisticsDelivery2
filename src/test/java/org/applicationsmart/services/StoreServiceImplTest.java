package org.applicationsmart.services;

import org.applicationsmart.models.Store;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StoreServiceImplTest {
    @Autowired
    private StoreService storeService;

    @Test
    @Sql("/scripts/insert.sql")
    public void testThatCustomerCanViewStore() {
        Store store = storeService.viewStore(001L);
        assertThat(store).isNotNull();
    }
}