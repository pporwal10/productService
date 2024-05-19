package dev.prateek.productservice.controllers;

import dev.prateek.productservice.dtos.GenericProductDTO;
import dev.prateek.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }
    @GetMapping()
    public List<GenericProductDTO> getAllProducts(){
        return productService.getProducts();
    }
    @GetMapping("{id}")
    public GenericProductDTO getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }
    @PostMapping()
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO product){
        return productService.createProduct(product);
    }
    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable("id") Long id){

    }
    @PutMapping("{id}")
    public void updateProductById(@PathVariable("id") Long id){

    }
}
