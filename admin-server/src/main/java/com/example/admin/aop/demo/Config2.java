package com.example.admin.aop.demo;


import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/*@Configuration*/
public class Config2 {

    @Bean
    public Bean2 bean2(){
            return new Bean2();
    }


}
