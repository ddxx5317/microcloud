package com.ddxx.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class Consumer_81_StartSpringCloudApplication {
	public static void main(String[] args) {
		SpringApplication.run(Consumer_81_StartSpringCloudApplication.class, args);
	}
}
