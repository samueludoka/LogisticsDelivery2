package org.applicationsmart.dtos.response;

import lombok.Getter;
import lombok.Setter;
import org.applicationsmart.models.Location;

@Getter
@Setter
public class VendorRegistrationResponse {
    private Long id;
    private String companyName;
    private String companyAddress;
    private Location location;
    private String regNo;
}
