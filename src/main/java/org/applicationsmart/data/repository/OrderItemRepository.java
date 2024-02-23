package org.applicationsmart.data.repository;

import org.applicationsmart.data.models.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderItemRepository extends MongoRepository<OrderItem, String> {
    OrderItem findOrderItemByType(String type);

}
