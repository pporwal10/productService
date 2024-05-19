package dev.prateek.productservice.service;

import dev.prateek.productservice.dtos.GenericProductDTO;

import java.util.List;

public interface ProductService {
    List<GenericProductDTO> getProducts();

    GenericProductDTO getProductById(Long Id);

    GenericProductDTO createProduct(GenericProductDTO product);
}
