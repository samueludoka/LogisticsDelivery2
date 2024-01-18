package org.applicationsmart.data.models;

import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ProductUpdateClass {
    private String id;
    private String name;
    private String description;
    private String type;
}
