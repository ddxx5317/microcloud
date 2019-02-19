package com.ddxx.microcloud.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddxx.microcloud.fallback.FeignClientFallBack;
import com.ddxx.vo.Dept;

@FeignClient(name="microcloud-provider-dept-8001",fallback=FeignClientFallBack.class)
public interface UserFeignClient {
 
	@RequestMapping(method = RequestMethod.GET, value = "/dept/list")
	public List<Dept> getDeptlist() ;
	
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept getDept(@PathVariable("id") long id);
	
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept getDeptWithFeign(@PathVariable("id") long id);
}