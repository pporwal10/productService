package dev.prateek.productservice.client;

import dev.prateek.productservice.dtos.FakeStoreProductDTO;
import dev.prateek.productservice.dtos.GenericProductDTO;
import dev.prateek.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ThirdPartyProductServiceClient {
    public FakeStoreProductDTO getProductById(Long Id);
    public FakeStoreProductDTO deleteProductById(Long Id) throws NotFoundException;
    public List<FakeStoreProductDTO> getAllProducts();
    public FakeStoreProductDTO createProduct(GenericProductDTO product);
    public FakeStoreProductDTO updateProductById(Long Id,GenericProductDTO product) throws NotFoundException;
    List<FakeStoreProductDTO> getProductsForCategory(String categoryId);
    List<String> getAllCategories();
}
