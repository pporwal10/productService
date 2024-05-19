package dev.prateek.productservice.service;

import dev.prateek.productservice.dtos.FakeStoreProductDTO;
import dev.prateek.productservice.dtos.GenericProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String getAllProductRequestUrl = "https://fakestoreapi.com/products";
    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";


    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    @Override
    public List<GenericProductDTO> getProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(getAllProductRequestUrl,FakeStoreProductDTO[].class);
        List<GenericProductDTO> genericProductDTOList = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO:response.getBody()){
            GenericProductDTO genericProductDTO = new GenericProductDTO();
            mapFakeStoreToGenericProductDTO(fakeStoreProductDTO,genericProductDTO);
            genericProductDTOList.add(genericProductDTO);
        }
        return genericProductDTOList;
    }

    private void mapFakeStoreToGenericProductDTO(FakeStoreProductDTO fakeStoreProductDTO, GenericProductDTO genericProductDTO) {
        genericProductDTO.setCategory(fakeStoreProductDTO.getCategory());
        genericProductDTO.setImage(fakeStoreProductDTO.getImage());
        genericProductDTO.setDescription(fakeStoreProductDTO.getDescription());
        genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
        genericProductDTO.setTitle(fakeStoreProductDTO.getTitle());
        genericProductDTO.setId(fakeStoreProductDTO.getID());
    }

    @Override
    public GenericProductDTO getProductById(Long Id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(getProductRequestUrl,FakeStoreProductDTO.class,Id);
        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        mapFakeStoreToGenericProductDTO(fakeStoreProductDTO,genericProductDTO);
        return  genericProductDTO;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.postForEntity(getAllProductRequestUrl,product,FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreProductDTO  = response.getBody();
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        mapFakeStoreToGenericProductDTO(fakeStoreProductDTO,genericProductDTO);
        return genericProductDTO;
    }

}
