package org.applicationsmart.services;

import org.applicationsmart.models.OrderItem;
import org.applicationsmart.repository.OrderItemRepository;
import org.applicationsmart.dtos.request.OrderItemDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderItemServiceImpl implements OrderItemService{
    @Autowired
    private OrderItemRepository orderItemRepository;
//    private String[] orderType = new String[5];
//    private int size;
    @Override
    public void addOrder() {

    }

    @Override
    public void editOrder() {

    }

    @Override
    public void deleteOrder() {

    }

    @Override
    public void SearchOrder() {

    }

    @Override
    public void placeOrder(OrderItemDetailsRequest orderDetailsRequest,String customerId) {
        OrderItem orderItem = new OrderItem();
        orderItem.setType(orderDetailsRequest.getType());
        orderItem.setProductNumber(orderDetailsRequest.getProductNumber());
        orderItem.setDescription(orderDetailsRequest.getDescription());
        orderItem.setCustomerId(customerId);
        orderItemRepository.save(orderItem);

    }
}
