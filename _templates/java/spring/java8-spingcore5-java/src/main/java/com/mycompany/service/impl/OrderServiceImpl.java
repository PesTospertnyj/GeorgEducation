package com.mycompany.service.impl;

import com.mycompany.service.ProductService;
import com.mycompany.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private String someProp;

    @Autowired
    private ProductService productService;

    @Override
    public void placeIphoneOrder() {
        System.out.println("OrderServiceImpl.placeIphoneOrder with price " + productService.getIphonePrice());
    }

    public String getSomeProp() {
        return someProp;
    }

    public void setSomeProp(final String someProp) {
        this.someProp = someProp;
    }
}
