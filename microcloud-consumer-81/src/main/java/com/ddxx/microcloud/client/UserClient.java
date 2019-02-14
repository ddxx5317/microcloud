package com.ddxx.microcloud.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddxx.vo.Dept;

@FeignClient("microcloud-provider-dept-8001")
public interface UserClient {
 
	@RequestMapping(method = RequestMethod.GET, value = "/dept/list")
	public List<Dept> getDeptlist() ;
}