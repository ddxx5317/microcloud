package com.ddxx.microcloud.fallback;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ddxx.microcloud.client.UserFeignClient;
import com.ddxx.vo.Dept;

@Component
public class FeignClientFallBack implements UserFeignClient {

	@Override
	public List<Dept> getDeptlist() {
		return null;
	}

	@Override
	public Dept getDept(long id) {
		return new Dept();
	}

	@Override
	public Dept getDeptWithFeign(long id) {
        Dept vo = new Dept() ;
        vo.setDeptno(8888888L);
        vo.setDname("【ERROR】Microcloud-Dept-Hystrix"); 
        vo.setLoc("microcloud-consumer-hystrix");
        return vo ;	}

}
