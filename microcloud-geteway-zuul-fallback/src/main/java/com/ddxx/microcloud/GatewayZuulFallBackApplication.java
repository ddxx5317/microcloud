package com.ddxx.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulFallBackApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayZuulFallBackApplication.class, args);
	}
}
