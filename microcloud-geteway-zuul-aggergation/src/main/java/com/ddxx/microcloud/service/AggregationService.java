package com.ddxx.microcloud.service;

import com.ddxx.vo.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

@Service
public class AggregationService {
  @Autowired
  private RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "fallback")
  public Observable<Dept> getDeptById(Long id) {
    // 创建一个被观察者
    return Observable.create(observer -> {
      // 请求用户微服务的/{id}端点
      Dept dept = restTemplate.getForObject("microcloud-provider-dept-without-auth/dept/get/{id}", Dept.class, id);
      observer.onNext(dept);
      observer.onCompleted();
    });
  }
  
  @HystrixCommand(fallbackMethod = "fallback")
  public Observable<Dept> getMovieUserByUserId(Long id) {
    return Observable.create(observer -> {
      // 请求电影微服务的/user/{id}端点
      Dept movieUser = restTemplate.getForObject("http://microservice-consumer-movie/user/{id}", Dept.class, id);
      observer.onNext(movieUser);
      observer.onCompleted();
    });
  }

  public Dept fallback(Long id) {
	  Dept dept = new Dept();
	  dept.setDeptno(999L);
	  dept.setDname("fallback");
    return dept;
  }
}
