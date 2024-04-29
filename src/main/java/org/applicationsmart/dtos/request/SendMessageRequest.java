package org.applicationsmart.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessageRequest {
    private String from;
    private String to;
    private String subject;
    private String text;
    private String send;

}
