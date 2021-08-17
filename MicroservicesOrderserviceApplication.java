package com.lara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MicroservicesOrderserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesOrderserviceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate  restTemplet() {
		return new RestTemplate();
	}

}
