package com.cts.microservices;

import org.apache.http.entity.ContentType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
@Slf4j
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	
	@Bean
//	@LoadBalanced
	public RestTemplate getRestTemplateWithLb() {
		return new RestTemplate();
	}
	

	
	@Bean
	public RequestInterceptor authInterceptor() {
		return (
				request->{
					request.header("auth", "This is a Header");
					request.header("Accept",ContentType.APPLICATION_JSON.getMimeType());
					log.info("Header Sent...");
				}
				
				
				
				);
	}
	
	
	

}
