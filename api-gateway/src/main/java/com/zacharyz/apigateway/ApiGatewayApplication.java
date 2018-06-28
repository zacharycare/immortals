package com.zacharyz.apigateway;

import com.zacharyz.apigateway.configuration.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class,args);
    }

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
