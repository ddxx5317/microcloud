package com.ddxx.microcloud.fallback;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ddxx.microcloud.client.UserFeignClient;
import com.ddxx.vo.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
	private static final Logger LOG = LoggerFactory.getLogger(FeignClientFallbackFactory.class);
	
	@Override
	public UserFeignClient create(Throwable cause) {
		return new UserFeignClient() {
			@Override
			public List<Dept> getDeptlist() {
				return null;
			}

			@Override
			public Dept getDept(long id) {
				return null;
			}

			@Override
			public Dept getDeptWithFeign(long id) {
				LOG.info("fallback reason: "+cause);
		        Dept vo = new Dept() ;
		        vo.setDeptno(6666666L);
		        vo.setDname("【ERROR】Microcloud-Dept-Hystrix-Fallback-factory");
		        vo.setLoc("DEPT-Provider");
		        return vo ;
			}
			
		};
	}

}
