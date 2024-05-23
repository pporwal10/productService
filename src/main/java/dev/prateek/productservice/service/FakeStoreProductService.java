package dev.prateek.productservice.service;

import dev.prateek.productservice.client.ThirdPartyProductServiceClient;
import dev.prateek.productservice.dtos.FakeStoreProductDTO;
import dev.prateek.productservice.dtos.GenericProductDTO;
import dev.prateek.productservice.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private ThirdPartyProductServiceClient thirdPartyProductServiceClient;
    public FakeStoreProductService(ThirdPartyProductServiceClient thirdPartyProductServiceClient){
        this.thirdPartyProductServiceClient=thirdPartyProductServiceClient;
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        List<GenericProductDTO> genericProductDTOList = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO:thirdPartyProductServiceClient.getAllProducts()){
            GenericProductDTO genericProductDTO = new GenericProductDTO();
            mapFakeStoreToGenericProductDTO(fakeStoreProductDTO,genericProductDTO);
            genericProductDTOList.add(genericProductDTO);
        }
        return genericProductDTOList;
    }



    @Override
    public GenericProductDTO getProductById(Long Id)  throws ArrayIndexOutOfBoundsException{
        if(Id>1000){
            throw new ArrayIndexOutOfBoundsException("Memory not available");
        }
        FakeStoreProductDTO fakeStoreProductDTO = thirdPartyProductServiceClient.getProductById(Id);
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        mapFakeStoreToGenericProductDTO(fakeStoreProductDTO,genericProductDTO);
        return  genericProductDTO;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {
      FakeStoreProductDTO fakeStoreProductDTO  = thirdPartyProductServiceClient.createProduct(product);
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        mapFakeStoreToGenericProductDTO(fakeStoreProductDTO,genericProductDTO);
        return genericProductDTO;
    }

    @Override
    public GenericProductDTO deleteProductById(Long id) throws NotFoundException {
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        mapFakeStoreToGenericProductDTO(thirdPartyProductServiceClient.deleteProductById(id), genericProductDTO);
        return genericProductDTO;
    }

    @Override
    public GenericProductDTO updateProductById(Long Id, GenericProductDTO product) throws NotFoundException {
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        mapFakeStoreToGenericProductDTO(thirdPartyProductServiceClient.updateProductById(Id,product), genericProductDTO);
        return genericProductDTO;
    }

    private void mapFakeStoreToGenericProductDTO(FakeStoreProductDTO fakeStoreProductDTO, GenericProductDTO genericProductDTO) {
        genericProductDTO.setCategory(fakeStoreProductDTO.getCategory());
        genericProductDTO.setImage(fakeStoreProductDTO.getImage());
        genericProductDTO.setDescription(fakeStoreProductDTO.getDescription());
        genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
        genericProductDTO.setTitle(fakeStoreProductDTO.getTitle());
        genericProductDTO.setId(fakeStoreProductDTO.getId());
    }

    @Override
    public List<GenericProductDTO> getProductsForCategory(String categoryId) {
        List<GenericProductDTO> genericProductDTOList = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO:thirdPartyProductServiceClient.getProductsForCategory(categoryId)){
            GenericProductDTO genericProductDTO = new GenericProductDTO();
            mapFakeStoreToGenericProductDTO(fakeStoreProductDTO,genericProductDTO);
            genericProductDTOList.add(genericProductDTO);
        }
        return genericProductDTOList;
    }

    @Override
    public List<String> getAllCategories() {
        return thirdPartyProductServiceClient.getAllCategories();
    }


}
