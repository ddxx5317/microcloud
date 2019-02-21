package com.ddxx.microcloud.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
	
	@Value("${profile}")
	private String profile;
	
	
	@Value("${url}")
	private String url;
	
	@Value("${password}")
	private String password;

	@GetMapping("/profile")
	public String hello() {
		return this.profile+":"+StringUtils.trimToEmpty(this.url);
	}
	
	@GetMapping("/encrypt")
	public String encrypt() {
		return this.profile+":"+StringUtils.trimToEmpty(this.url)+":"+this.password;
	}
	
	@GetMapping("/decrypt")
	public String decrypt() {
		return this.profile+":"+StringUtils.trimToEmpty(this.url)+":"+this.password;
	}
}
