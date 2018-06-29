package com.mycompany.service.impl;

import com.mycompany.service.MyService;

public class MyServiceImpl implements MyService {

    private String someProp;

    @Override
    public void foo() {
        System.out.println("MyService.foo");
        System.out.println("someProp = " + someProp);
    }

    public String getSomeProp() {
        return someProp;
    }

    public void setSomeProp(final String someProp) {
        this.someProp = someProp;
    }
}
