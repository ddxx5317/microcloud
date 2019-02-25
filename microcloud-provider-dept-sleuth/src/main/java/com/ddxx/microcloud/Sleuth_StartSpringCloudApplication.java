package com.ddxx.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Sleuth_StartSpringCloudApplication {
	public static void main(String[] args) {
		SpringApplication.run(Sleuth_StartSpringCloudApplication.class, args);
	}
}
