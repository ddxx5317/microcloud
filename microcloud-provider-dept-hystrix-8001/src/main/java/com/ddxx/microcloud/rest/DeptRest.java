package com.ddxx.microcloud.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ddxx.microcloud.service.IDeptService;
import com.ddxx.vo.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptRest {
	@Resource
	private IDeptService deptService ;
	
	@RequestMapping("/dept/sessionId")
	public Object id(HttpServletRequest request) {
		return request.getSession().getId() ;
	}
	@HystrixCommand(fallbackMethod="getFallback")    // 如果当前调用的get()方法出现了错误，则执行fallback
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") long id) {
        Dept vo = this.deptService.get(id) ;    // 接收数据库的查询结果
        if (vo == null) {    // 数据不存在，假设让它抛出个错误
            throw new RuntimeException("部门信息不存在！") ;
        }
        return vo ;
	}
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public Object add(@RequestBody Dept dept) {
		return this.deptService.add(dept) ;
	}
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public Object list() {
		return this.deptService.list() ;
	}
	
    public Dept getFallback(@PathVariable("id") long id) {    // 此时方法的参数 与get()一致
        Dept vo = new Dept() ;
        vo.setDeptno(999999L);
        vo.setDname("【ERROR】Microcloud-Dept-Hystrix");    // 错误的提示
        vo.setLoc("DEPT-Provider");
        return vo ;
    }
}
