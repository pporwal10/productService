package dev.prateek.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private long ID;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}