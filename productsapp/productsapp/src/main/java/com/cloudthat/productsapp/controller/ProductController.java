package com.cloudthat.productsapp.controller;

import com.cloudthat.productsapp.entity.Product;
import com.cloudthat.productsapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {

        return productService.saveProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getProducts();

    }
    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable("productId") Long productId){
        return productService.getProduct(productId);
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product){
        return productService.updateProduct(productId, product);
    }

    @DeleteMapping("/products/{productId}")
    public Product deleteProduct(@PathVariable("productId") Long productId){

        return  productService.deleteProduct(productId);
    }
}
