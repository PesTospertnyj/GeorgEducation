package com.mycompany.service.impl;

import com.mycompany.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class ProductServiceImpl implements ProductService {

    @Value("${iphone.price}")
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getIphonePrice() {
        return price;
    }
}
