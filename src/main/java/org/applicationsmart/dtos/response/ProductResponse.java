package org.applicationsmart.dtos.response;

import lombok.Getter;
import lombok.Setter;
import org.applicationsmart.models.ProductCategory;

@Getter
@Setter
public class ProductResponse {
    private String name;
    private String number;
    private String description;
    private String items;
    private String customerId;
    private ProductCategory productCategory;
}
