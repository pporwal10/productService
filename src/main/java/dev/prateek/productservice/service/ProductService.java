package dev.prateek.productservice.service;

import dev.prateek.productservice.dtos.GenericProductDTO;
import dev.prateek.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
    List<GenericProductDTO> getProducts();

    GenericProductDTO getProductById(Long Id) throws ArrayIndexOutOfBoundsException;

    GenericProductDTO createProduct(GenericProductDTO product);

    GenericProductDTO deleteProductById(Long id) throws NotFoundException;

    GenericProductDTO updateProductById(Long Id, GenericProductDTO product) throws NotFoundException;

    List<GenericProductDTO> getProductsForCategory(String categoryId);

    List<String> getAllCategories();
}
