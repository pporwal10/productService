package dev.prateek.productservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseModel {

    @Id
    @GeneratedValue(generator = "prateek")
    @GenericGenerator(name = "prateek", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
    private UUID uid;
    String createdBy;
    Date createdOn;
}
