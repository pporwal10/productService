package dev.prateek.productservice.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Category extends BaseModel{
    private String name;
}
