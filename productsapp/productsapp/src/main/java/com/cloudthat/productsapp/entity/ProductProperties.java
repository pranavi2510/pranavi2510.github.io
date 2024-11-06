package com.cloudthat.productsapp.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProductProperties {
    private String productColor;
    private Integer productLength;
    private Integer productWidth;
    private Integer productHeigth;

    public ProductProperties(String productColor, Integer productLength, Integer productWidth, Integer productHeigth) {
        this.productColor = productColor;
        this.productLength = productLength;
        this.productWidth = productWidth;
        this.productHeigth = productHeigth;
    }
    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public Integer getProductLength() {
        return productLength;
    }

    public void setProductLength(Integer productLength) {
        this.productLength = productLength;
    }

    public Integer getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(Integer productWidth) {
        this.productWidth = productWidth;
    }

    public Integer getProductHeigth() {
        return productHeigth;
    }

    public ProductProperties() {
    }

    public void setProductHeigth(Integer productHeigth) {
        this.productHeigth = productHeigth;
    }

}
