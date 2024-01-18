package org.applicationsmart.data.models;

import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class CourierBatch {
    private String id;
    private Date CreationDate;
    private Courier Note;
}
