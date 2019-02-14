package com.mycompany.context;

import com.mycompany.service.OrderService;
import com.mycompany.service.ProductService;
import com.mycompany.service.impl.OrderServiceImpl;
import com.mycompany.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.mycompany")
public class Config {

    @Bean
    public OrderService orderService() {
        final OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.setProductService(productService());
        return orderService;
    }

    @Bean
    public ProductService productService() {
        final ProductServiceImpl productService = new ProductServiceImpl();
        return productService;
    }

    @Bean
    public static PropertyPlaceholderConfigurer properties() {
        PropertyPlaceholderConfigurer ppc
                = new PropertyPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[]
                { new ClassPathResource( "messages.properties" ) };
        ppc.setLocations( resources );
        ppc.setIgnoreUnresolvablePlaceholders( true );
        return ppc;
    }


}
