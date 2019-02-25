package com.ddxx.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ddxx.microcloud.ZipkinStartSpringCloudApplication;
import com.ddxx.microcloud.service.IDeptService;
import com.ddxx.vo.Dept;


@SpringBootTest(classes = ZipkinStartSpringCloudApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class IDeptServiceTest {
	@Resource
	private IDeptService deptService ;
	@Test
	public void testGet() {
		System.out.println(this.deptService.get(1));
	}

	@Test
	public void testAdd() {
		Dept dept = new Dept() ;
		dept.setDname("测试部-" + System.currentTimeMillis());
		System.out.println(this.deptService.add(dept)); 
	}

	@Test
	public void testList() {
		System.out.println(this.deptService.list());
	}

}
