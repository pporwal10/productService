package dev.prateek.productservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {
    long id;
    String createdBy;
    Date createdOn;
}
