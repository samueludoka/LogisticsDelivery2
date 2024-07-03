package org.applicationsmart.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreResponse {
    private Long id;
    private String storeId;
    private Long vendorId;
    private Long productId;
    private VendorResponse vendor;
    private ProductResponse product;
}
