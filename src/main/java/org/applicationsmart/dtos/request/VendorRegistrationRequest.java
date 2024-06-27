package org.applicationsmart.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.applicationsmart.models.Location;

@Getter
@Setter
public class VendorRegistrationRequest {
    private String companyName;
    private String companyAddress;
    private Location location;
    private String  regNo;
}
