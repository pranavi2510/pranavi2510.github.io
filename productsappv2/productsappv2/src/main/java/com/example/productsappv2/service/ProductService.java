package com.example.productsappv2.service;



import com.example.productsappv2.entity.Product;
import com.example.productsappv2.model.ProductModel;
import com.example.productsappv2.model.ProductRequest;

import java.util.List;

public interface ProductService {
    ProductModel saveProduct(ProductRequest productRequest);

    List<ProductModel> getProducts();

    ProductModel getProduct(Long productId);

    Product updateProduct(Long productId, Product product);

    void deleteProduct(Long productId);

    Product getProductByName(String productName);
}