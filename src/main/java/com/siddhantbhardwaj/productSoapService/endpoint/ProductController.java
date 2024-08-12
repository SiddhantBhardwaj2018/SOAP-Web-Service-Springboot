package com.siddhantbhardwaj.productSoapService.endpoint;

import com.siddhantbhardwaj.productSoapService.converter.ProductConverter;
import com.siddhantbhardwaj.productSoapService.gen.*;
import com.siddhantbhardwaj.productSoapService.model.ProductModel;
import com.siddhantbhardwaj.productSoapService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class ProductController {

    private static final String NAMESPACE_URI = "http://www.siddhantbhardwaj.com/productSoapService/gen";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProductResponse(@RequestPayload GetProductRequest getProductRequest) throws Exception {
        GetProductResponse getProductResponse = new GetProductResponse();
        ProductModel productModel = productRepository.findProductByName(getProductRequest.getName());
        getProductResponse.setProduct(productConverter.convertProductModelToProduct(productModel));
        return  getProductResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse getProductsResponse(@RequestPayload GetProductsRequest getProductsRequest) throws Exception{
        GetProductsResponse getProductsResponse = new GetProductsResponse();
        List<ProductModel> productModelList = productRepository.findAll();
        System.out.println(productModelList);
        List<Product> productList = productConverter.convertProductModelsToProduct(productModelList);
        System.out.println(productList);
        getProductsResponse.getProducts().addAll(productList);
        return getProductsResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "postProductRequest")
    @ResponsePayload
    public PostProductResponse postProductResponse(@RequestPayload PostProductRequest postProductRequest) throws Exception{
        PostProductResponse postProductResponse = new PostProductResponse();
        ProductModel productModel = productConverter.convertProductToProductModel(postProductRequest.getProduct());
        productRepository.save(productModel);
        postProductResponse.setProduct(productConverter.convertProductModelToProduct(productModel));
        return postProductResponse;
    }

}
