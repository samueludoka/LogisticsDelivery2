package org.applicationsmart.exception;

public class InvalidDetailsException extends LogisticsDeliveryException{
    public InvalidDetailsException() {
        super("invalid username or password");
    }
}
