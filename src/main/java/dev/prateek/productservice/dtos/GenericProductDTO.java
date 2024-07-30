package dev.prateek.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GenericProductDTO implements Serializable {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}