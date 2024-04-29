package org.applicationsmart.services;

import org.applicationsmart.dtos.request.SendMessageRequest;

public interface EmailService {
     void sendSimpleMessage(SendMessageRequest request);


}
