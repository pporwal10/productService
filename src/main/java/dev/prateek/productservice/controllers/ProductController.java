package dev.prateek.productservice.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping()
    public String getAllProducts(){
        System.out.println("hello world");
        return "AllProducts";
    }
    @GetMapping("{id}")
    public String getProductById(@PathVariable("id") Long id){
        return "HEllo: "+id;
    }
    @PostMapping()
    public void createProduct(){

    }
    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable("id") Long id){

    }
    @PutMapping("{id}")
    public void updateProductById(@PathVariable("id") Long id){

    }
}
