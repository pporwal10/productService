package dev.prateek.productservice.service;

import dev.prateek.productservice.dtos.GenericProductDTO;
import dev.prateek.productservice.exceptions.NotFoundException;
import dev.prateek.productservice.model.Category;
import dev.prateek.productservice.model.Product;
import dev.prateek.productservice.repository.CategoryRepository;
import dev.prateek.productservice.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Service
public class GenericProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public GenericProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<GenericProductDTO> genericProductDTOList = new ArrayList<>();
        for(Product p:productList){
            genericProductDTOList.add(mapperProductDto(p));
        }
        return genericProductDTOList;
    }

    private GenericProductDTO mapperProductDto(Product p) {
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setDescription(p.getDescription());
        genericProductDTO.setTitle(p.getTitle());
        genericProductDTO.setPrice(p.getPrice());
        genericProductDTO.setCategory(p.getCategory().getName());
        genericProductDTO.setImage(p.getImage());
        genericProductDTO.setId(p.getId());
        return genericProductDTO;
    }

    @Override
    public GenericProductDTO getProductById(Long Id) {
        Optional<Product> op = Optional.of(productRepository.getById(Id));
        if(op.isPresent()){
            return mapperProductDto(op.get());
        }
        return null;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {
        Category category = new Category();
        category.setName(product.getCategory());
        Category savedCategory = categoryRepository.save(category);
        Product p = new Product();
        p.setDescription(product.getDescription());
        p.setTitle(product.getTitle());
        p.setPrice(product.getPrice());
        p.setImage(product.getImage());
        p.setCategory(savedCategory);
        Product savedProduct=productRepository.save(p);
        return mapperProductDto(savedProduct);
    }

    @Override
    public GenericProductDTO deleteProductById(Long id) {
        productRepository.deleteById(id);
        return null;
    }

    @Override
    public GenericProductDTO updateProductById(Long Id, GenericProductDTO product) throws NotFoundException {
        Optional <Product> p = productRepository.findById(Id);
        if(p.isPresent()){
            Product pr = p.get();
            pr.setImage(product.getImage());
            pr.setDescription(product.getDescription());
            pr.setTitle(product.getTitle());
            pr.setPrice(product.getPrice());
            Product savedProduct=productRepository.save(pr);
            return mapperProductDto(savedProduct);
        }
        else{
            throw new NotFoundException("Item Not Found");
        }
    }

    @Override
    public List<GenericProductDTO> getProductsForCategory(String categoryId) {
        List<Product> li=productRepository.findAllByCategory_Name(categoryId);
        List<GenericProductDTO> genericProductDTOList= new ArrayList<>();
        for(Product p:li){
            genericProductDTOList.add(mapperProductDto(p));
        }
        return genericProductDTOList;
    }

    @Override
    public List<String> getAllCategories() {
        List<Category> categoryList=categoryRepository.findAll();
        List<String> op = new ArrayList<>();
        for(Category c:categoryList){
            op.add(c.getName());
        }
        return op;
    }
}
