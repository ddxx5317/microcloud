package com.ddxx.microcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ddxx.microcloud.client.UserFeignClient;
import com.ddxx.vo.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConsumerDeptController {

	@Resource
	private UserFeignClient userClient;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Dept> list() {
		return userClient.getDeptlist();
	}
	
	@RequestMapping(value="/dept/get_with_feign/{id}",method=RequestMethod.GET)
	public Dept getDeptWithFeign(@PathVariable("id") long id) {
        return this.userClient.getDeptWithFeign(id);
	}
	
	@HystrixCommand(fallbackMethod="getFallback")    // 如果当前调用的get()方法出现了错误，则执行fallback
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept getDept(@PathVariable("id") long id) {
        Dept vo = this.userClient.getDept(id) ;    // 接收数据库的查询结果
        if (vo == null) {    // 数据不存在，假设让它抛出个错误
            throw new RuntimeException("部门信息不存在！") ;
        }
        return vo ;
	}
	
    public Dept getFallback(@PathVariable("id") long id) {    // 此时方法的参数 与get()一致
        Dept vo = new Dept() ;
        vo.setDeptno(999999L);
        vo.setDname("【ERROR】Microcloud-Dept-Hystrix");    // 错误的提示
        vo.setLoc("DEPT-Provider");
        return vo ;
    }
}
