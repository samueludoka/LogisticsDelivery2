package org.applicationsmart.dtos.request;

import lombok.Data;

@Data
public class OrderRequest {
    private String type;
    private String description;
}
