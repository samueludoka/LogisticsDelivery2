package org.applicationsmart.dtos.request;

import lombok.Data;

@Data
public class OrderItemDetailsRequest {
    private String type;
    private String description;
    private String number;
    private String customerId;


}
