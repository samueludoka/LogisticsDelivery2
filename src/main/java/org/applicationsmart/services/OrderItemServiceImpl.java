package org.applicationsmart.services;

import lombok.Data;
import org.applicationsmart.dtos.request.OrderItemDetailsRequest;
import org.springframework.stereotype.Service;
@Data

@Service
public class OrderItemServiceImpl implements OrderItemService{
    private String[] orderType = new String[5];
    private int size;
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
    public int placeOrder(OrderItemDetailsRequest orderDetailsRequest) {

        return size++;
    }
}
