package org.applicationsmart.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.applicationsmart.models.Location;

@Getter
@Setter
public class CustomerRegistrationRequest {
    private String customerAddress;
    private Location customerLocation;
}
