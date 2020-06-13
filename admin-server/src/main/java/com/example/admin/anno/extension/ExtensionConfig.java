package com.example.admin.anno.extension;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.example.admin.anno.extension")
@Configuration
public class ExtensionConfig {

    @Bean
    public  Car car(){
        return  new Car();
    }

}
