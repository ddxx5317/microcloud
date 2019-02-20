package com.ddxx.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.ddxx.microcloud.filter.PreRequestLogFilter;

@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulFilterApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayZuulFilterApplication.class, args);
	}
	
	@Bean
	public PreRequestLogFilter preRequestLogFilter() {
		return new PreRequestLogFilter();
	}
}
