package com.siddhantbhardwaj.productSoapService.repository;

import com.siddhantbhardwaj.productSoapService.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel,Integer> {

    public ProductModel findProductByName(String name) throws Exception;

}
