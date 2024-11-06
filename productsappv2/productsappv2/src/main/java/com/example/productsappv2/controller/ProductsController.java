package com.example.productsappv2.controller;


import com.example.productsappv2.entity.Product;
import com.example.productsappv2.model.ApiResponse;
import com.example.productsappv2.model.ProductModel;
import com.example.productsappv2.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {
    @Autowired
    private com.example.productsappv2.service.ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductRequest productRequest){
        ProductModel productModel = productService.saveProduct(productRequest);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true,"Product Fetch Successful", productModel ), HttpStatus.OK );
    }

    @GetMapping("/products")
    public ResponseEntity<ApiResponse> getAllProducts(){
        List<ProductModel> productModels =  productService.getProducts();
        return new ResponseEntity<ApiResponse>(new ApiResponse(true,"Product Fetch Successful", productModels ), HttpStatus.OK );

    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ApiResponse> getProduct(@PathVariable("productId") Long productId){
        ProductModel productModel = productService.getProduct(productId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true,"Product Fetch Successful", productModel ), HttpStatus.OK );
    }


    @PutMapping("/products/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product){
        return productService.updateProduct(productId, product);
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
        return "Product Deleted Successfully";
    }

    @GetMapping("/products/names/{productName}")
    public Product getProductByName(@PathVariable("productName") String productName){
        return productService.getProductByName(productName);
    }
    @GetMapping("/products/pages")
    public ResponseEntity<ApiResponse> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "productName") String sort,
            @RequestParam(defaultValue = "asc") String direction
    ){
            Page<ProductModel> products = productService.getProducts(page, size, sort, direction);
            return new ResponseEntity<ApiResponse>(new ApiResponse(true,"Products Fetch Successful", products ), HttpStatus.OK );
    }
}