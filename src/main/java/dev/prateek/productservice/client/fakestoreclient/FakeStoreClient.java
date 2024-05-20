package dev.prateek.productservice.client.fakestoreclient;

import dev.prateek.productservice.client.ThirdPartyProductServiceClient;
import dev.prateek.productservice.dtos.FakeStoreProductDTO;
import dev.prateek.productservice.dtos.GenericProductDTO;
import dev.prateek.productservice.exceptions.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreClient implements ThirdPartyProductServiceClient {

    private RestTemplateBuilder restTemplateBuilder;
    private String getAllProductRequestUrl = "https://fakestoreapi.com/products";
    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";


    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }


    public List<FakeStoreProductDTO> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(getAllProductRequestUrl,FakeStoreProductDTO[].class);

        return Arrays.stream(response.getBody()).toList();
    }



    @Override
    public FakeStoreProductDTO getProductById(Long Id)  throws ArrayIndexOutOfBoundsException{
        if(Id>1000){
            throw new ArrayIndexOutOfBoundsException("Memory not available");
        }
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(getProductRequestUrl,FakeStoreProductDTO.class,Id);
        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
        return fakeStoreProductDTO;
    }

    @Override
    public FakeStoreProductDTO createProduct(GenericProductDTO product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.postForEntity(getAllProductRequestUrl,product,FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreProductDTO  = response.getBody();
        return fakeStoreProductDTO;
    }

    @Override
    public FakeStoreProductDTO deleteProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);
        ResponseEntity<FakeStoreProductDTO>response = restTemplate.execute(getProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        if(response.getBody()==null){
            throw new NotFoundException("Product with id"+id+" doesn't exist");
        }
        return response.getBody();
    }

}
