/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.service.MySecondService;
import com.mycompany.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Georgii_Gavrysh
 */
public class Main {
    public static void main(String... args) {
        final ApplicationContext context =
             new ClassPathXmlApplicationContext("Beans.xml");

        final MyService myService = context.getBean(MyService.class);
        myService.foo();

        final MySecondService mySecondService = context.getBean(MySecondService.class);
        mySecondService.bar();

    }
}
