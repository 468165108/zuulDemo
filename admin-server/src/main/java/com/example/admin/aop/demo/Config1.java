package com.example.admin.aop.demo;


import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;

/*@Order(Integer.MIN_VALUE)
@Configuration*/
public class Config1 implements PriorityOrdered {

    @Bean
    @ConditionalOnBean(Bean2.class)
    @Order(Integer.MIN_VALUE)
    public Bean1 bean1() {
            return new Bean1();
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;// within PriorityOrdered
    }
}
