package dev.prateek.productservice.service;

import dev.prateek.productservice.dtos.GenericProductDTO;
import dev.prateek.productservice.exceptions.NotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Primary
@Service
public class GenericProductService implements ProductService{
    @Override
    public List<GenericProductDTO> getProducts() {
        return null;
    }

    @Override
    public GenericProductDTO getProductById(Long Id) {
        return null;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {
        return null;
    }

    @Override
    public GenericProductDTO deleteProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDTO updateProductById(Long Id, GenericProductDTO product) throws NotFoundException {
        return null;
    }

    @Override
    public List<GenericProductDTO> getProductsForCategory(String categoryId) {
        return null;
    }

    @Override
    public List<String> getAllCategories() {
        return List.of();
    }
}
