package org.applicationsmart.exception;

public class ProductAlreadyAddedToStoreException extends RuntimeException {
    public ProductAlreadyAddedToStoreException(String message){
        super(message);
    }
}
