package org.applicationsmart.services;

import org.applicationsmart.dtos.request.OrderItemDetailsRequest;


public interface OrderItemService {
    void addOrder();
    void editOrder();
    void deleteOrder();
    void SearchOrder();

    void placeOrder(OrderItemDetailsRequest orderDetailsRequest,String customerId);
}
