package org.applicationsmart.data.models;

import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Product {
    private String id;
    private String number;
    private String description;
    private String items;
    private String customerId;
}
