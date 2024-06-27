package org.applicationsmart.dtos.response;

import lombok.Getter;
import lombok.Setter;
import org.applicationsmart.models.Location;

@Getter
@Setter
public class CustomerRegistrationResponse {
    private String customerAddress;
    private Location customerLocation;
}
