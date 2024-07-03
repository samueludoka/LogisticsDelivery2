package org.applicationsmart.dtos.response;

import lombok.Getter;
import lombok.Setter;
import org.applicationsmart.models.Location;

@Getter
@Setter
public class VendorResponse {
    private Long id;
    private String companyName;
    private String companyAddress;
    private boolean registrationStatus;
    private Location location;
    private String regNo;
}
