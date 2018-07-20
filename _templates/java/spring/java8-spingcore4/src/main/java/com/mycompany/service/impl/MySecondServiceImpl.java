package com.mycompany.service.impl;

import com.mycompany.service.MySecondService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MySecondServiceImpl implements MySecondService {

    @Value("${prop2}")
    private String someProperty;

    @Override
    public void bar() {
        System.out.println("MySecondServiceImpl.bar");
        System.out.println("someProperty = " + someProperty);
    }

    public String getSomeProperty() {
        return someProperty;
    }

    public void setSomeProperty(final String someProperty) {
        this.someProperty = someProperty;
    }
}
