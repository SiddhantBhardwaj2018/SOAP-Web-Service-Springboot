package com.siddhantbhardwaj.productSoapService.converter;

import com.siddhantbhardwaj.productSoapService.gen.Product;
import com.siddhantbhardwaj.productSoapService.model.ProductModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {
    public ProductModel convertProductToProductModel(Product product) throws Exception{
        ProductModel productModel = new ProductModel();
        productModel.setId(product.getId());
        productModel.setName(product.getName());
        productModel.setPrice(product.getPrice());
        productModel.setDescription(product.getDescription());
        return productModel;
    }

    public Product convertProductModelToProduct(ProductModel productModel) throws Exception{
        Product product = new Product();
        product.setId(productModel.getId());
        product.setName(productModel.getName());
        product.setDescription(productModel.getDescription());
        product.setPrice(productModel.getPrice());
        return product;
    }

    public List<ProductModel> convertProductsToProductModels(List<Product> productList) throws Exception{
        List<ProductModel> productModelList = new ArrayList<>();
        productList.stream().forEach(product -> {
            ProductModel productModel = new ProductModel();
            productModel.setId(product.getId());
            productModel.setName(product.getName());
            productModel.setDescription(product.getDescription());
            productModel.setPrice(product.getPrice());
        });
        return productModelList;
    }

    public List<Product> convertProductModelsToProduct(List<ProductModel> productModelList) throws Exception{
        List<Product> productList = new ArrayList<>();
        productModelList.stream().forEach(
                productModel -> {
                    Product product = new Product();
                    product.setId(productModel.getId());
                    product.setName(productModel.getName());
                    product.setDescription(productModel.getDescription());
                    product.setPrice(productModel.getPrice());
                    productList.add(product);
                }
        );
        return productList;
    }

}
