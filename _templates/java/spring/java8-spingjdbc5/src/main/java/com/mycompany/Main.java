/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.context.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Georgii_Gavrysh
 */
public class Main {

    public final static ApplicationContext APPLICATION_CONTEXT =
            new AnnotationConfigApplicationContext(Config.class);

    public static void main(String... args) {


        final JdbcTemplate jdbcTemplate = APPLICATION_CONTEXT.getBean(JdbcTemplate.class);
        System.out.println("info from db = " + jdbcTemplate.queryForObject("select text from message", String.class));

    }
}
