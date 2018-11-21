package com.mycompany.service.impl;

import com.mycompany.service.MySecondService;
import com.mycompany.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import static com.mycompany.Main.APPLICATION_CONTEXT;

@Service
public class MyServiceImpl implements MyService {

    private String someProp;

    @Autowired
    private MySecondService mySecondService;

    @Override
    public void foo() {
        System.out.println("MyService.foo");
        System.out.println("someProp = " + someProp);
        mySecondService.bar();
    }

    public String getSomeProp() {
        return someProp;
    }

    public void setSomeProp(final String someProp) {
        this.someProp = someProp;
    }
}
