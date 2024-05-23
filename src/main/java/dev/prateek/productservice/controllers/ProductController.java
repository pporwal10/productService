package dev.prateek.productservice.controllers;

import dev.prateek.productservice.dtos.ExceptionDTO;
import dev.prateek.productservice.dtos.GenericProductDTO;
import dev.prateek.productservice.exceptions.NotFoundException;
import dev.prateek.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public List<GenericProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public GenericProductDTO getProductById(@PathVariable("id") Long id) throws ArrayIndexOutOfBoundsException{
        return productService.getProductById(id);
    }

    @PostMapping()
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO product){
        return productService.createProduct(product);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDTO> deleteProductById(@PathVariable("id") Long id) throws NotFoundException {
        return new ResponseEntity<>(productService.deleteProductById(id) , HttpStatus.OK);
    }

    @PutMapping("{id}")
    public GenericProductDTO updateProductById(@RequestBody GenericProductDTO product, @PathVariable("id") Long id) throws NotFoundException{
        return productService.updateProductById(id,product);
    }
    @GetMapping("/category/{categoryId}")
    public List<GenericProductDTO> getProductsForCategory(@PathVariable("categoryId") String categoryId){
        return productService.getProductsForCategory(categoryId);
    }
    @GetMapping("/categories")
    public List<String> getAllCategories(){
        return productService.getAllCategories();
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleNotFoundException(NotFoundException notFoundException){
        return new ResponseEntity(new ExceptionDTO(HttpStatus.NOT_FOUND,notFoundException.getMessage()),HttpStatus.NOT_FOUND);
    }
}
