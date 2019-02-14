package com.ddxx.microcloud.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddxx.vo.Dept;

@FeignClient("microcloud-provider-dept-8001")
public interface UserClient {
 
	@RequestMapping(method = RequestMethod.GET, value = "/dept/list")
	public List<Dept> getDeptlist() ;
	
	@RequestMapping(value = "/dept", method = RequestMethod.POST)
	public Dept postDept(@RequestBody Dept dept);
	
	// 该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求。可能是我没找到相应的注解或使用方法错误。
	@RequestMapping(value = "/get-dept", method = RequestMethod.GET)
	public Dept getDept(Dept dept);
}