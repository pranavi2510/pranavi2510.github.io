package com.cloudthat.productsapp.service;

import com.cloudthat.productsapp.entity.Product;
import com.cloudthat.productsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    @Override
    public List<Product> getProducts(){
        return productRepository.findAll();

    }
    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId){
        productRepository.deleteById(productId);
        return null;
    }

}



