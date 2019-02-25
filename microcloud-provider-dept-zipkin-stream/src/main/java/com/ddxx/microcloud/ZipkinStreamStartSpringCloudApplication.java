package com.ddxx.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZipkinStreamStartSpringCloudApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZipkinStreamStartSpringCloudApplication.class, args);
	}
}
