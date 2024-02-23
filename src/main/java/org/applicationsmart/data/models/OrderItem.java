package org.applicationsmart.data.models;

import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document

public class OrderItem {
    @Id
    private String id;
    private String type;
    private String description;
    private String productNumber;
    private String customerId;


}
