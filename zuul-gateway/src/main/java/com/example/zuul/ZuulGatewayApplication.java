package com.example.zuul;

import com.example.zuul.filtter.LoggerStartFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ZuulGatewayApplication {

	@Bean
	public LoggerStartFilter loggerStartFilter() {
		return new LoggerStartFilter();
	}


	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}
}
