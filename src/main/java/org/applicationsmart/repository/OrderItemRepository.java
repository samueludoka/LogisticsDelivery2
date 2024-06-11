package org.applicationsmart.repository;

import org.applicationsmart.models.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderItemRepository extends MongoRepository<OrderItem, String> {
    OrderItem findOrderItemByType(String type);

}
