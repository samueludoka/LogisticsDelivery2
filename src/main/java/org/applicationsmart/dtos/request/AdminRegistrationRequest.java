package org.applicationsmart.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRegistrationRequest {
    private Long id;
    private boolean isActive;
}
