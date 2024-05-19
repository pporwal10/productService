package dev.prateek.productservice.model;

import lombok.Data;

@Data
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    private Category category;
    private double price;
}
