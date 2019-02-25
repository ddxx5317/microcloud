package com.ddxx.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZipkinStartSpringCloudApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZipkinStartSpringCloudApplication.class, args);
	}
}
