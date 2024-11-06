package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Book book(){
        return new Book("1234567","Introduction to Spring", new Author("Vishwas K Singh", 12));
    }
}