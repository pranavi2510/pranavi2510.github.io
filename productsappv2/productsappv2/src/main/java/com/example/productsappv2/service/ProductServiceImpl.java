
package com.example.productsappv2.service;


import com.example.productsappv2.entity.Product;
import com.example.productsappv2.model.ProductModel;
import com.example.productsappv2.model.ProductRequest;
import com.example.productsappv2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductModel saveProduct(ProductRequest productRequest) {
        ProductModel newProductModel = new ProductModel();
        newProductModel.setProductName(productRequest.getProductName());
        newProductModel.setPrice(productRequest.getPrice());
        newProductModel.setCategory(productRequest.getCategory());

        Product product = productRepository.save(productModelToProduct(newProductModel));
        return productToProductModel(product);
    }

    @Override
    public List<ProductModel> getProducts() {
        List<ProductModel> productModels = new ArrayList<ProductModel>();
        List<Product> products = productRepository.findAll();
        for(Product p : products){
            productModels.add(productToProductModel(p));
        }
        return productModels;
    }

    @Override
    public ProductModel getProduct(Long productId) {
        return productToProductModel(productRepository.findById(productId).get());
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        Product productDB = productRepository.findById(productId).get();

        if(Objects.nonNull(product.getProductName()) && !("".equalsIgnoreCase(product.getProductName()))){
            productDB.setProductName(product.getProductName());
        }

        return productRepository.save(productDB);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product getProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    private Product productModelToProduct(ProductModel productModel){
        Product product = new Product();
        product.setId(productModel.getId());
        product.setProductName(productModel.getProductName());
        product.setCategory(productModel.getCategory());
        product.setPrice(product.getPrice());
        return  product;
    }

    private ProductModel productToProductModel(Product product){
        ProductModel productModel = new ProductModel();
        productModel.setId(product.getId());
        productModel.setProductName(product.getProductName());
        productModel.setPrice(product.getPrice());
        productModel.setCategory(product.getCategory());

        return productModel;
    }
}
