package com.ddxx.microcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ddxx.microcloud.client.UserClient;
import com.ddxx.vo.Dept;

@RestController
public class ConsumerDeptController {
	public static final String DEPT_GET_URL = "http://dept-8001.com:8001/dept/get/";
	public static final String DEPT_LIST_URL = "http://dept-8001.com:8001/dept/list/";
	public static final String DEPT_ADD_URL = "http://dept-8001.com:8001/dept/add?dname=";
	
	@Resource
	private RestTemplate restTemplate;
	
	@Resource
	private HttpHeaders headers;
	
	@Resource
	private UserClient userClient;
	
	@Resource
	private LoadBalancerClient loadBalancerClient;
	
	
	@GetMapping("/test")
	public String test() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("microcloud-provider-dept-8001");
		System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

		return "1";
	  }
	  
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Dept> list() {
		return userClient.getDeptlist();
	}
	
	@RequestMapping(value = "/consumer/dept/get")
	public Object getDept(long id) {
		Dept dept = this.restTemplate
				.exchange(DEPT_GET_URL + id, HttpMethod.GET,new HttpEntity<Object>(this.headers), Dept.class)
				.getBody();
		return dept;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
	public Object listDept() {
		List<Dept> allDepts = this.restTemplate
				.exchange(DEPT_LIST_URL, HttpMethod.GET,new HttpEntity<Object>(this.headers), List.class)
				.getBody();
		return allDepts;
	}
	@RequestMapping(value = "/consumer/dept/add")
	public Object addDept(Dept dept) throws Exception {
		Boolean flag = this.restTemplate.exchange(DEPT_ADD_URL, HttpMethod.POST,
				new HttpEntity<Object>(dept, this.headers), Boolean.class)
				.getBody();
		return flag;
	}
}
