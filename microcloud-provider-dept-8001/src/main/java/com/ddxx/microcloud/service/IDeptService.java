package com.ddxx.microcloud.service;

import java.util.List;

import com.ddxx.vo.Dept;
public interface IDeptService {
	public Dept get(long id) ;
	public boolean add(Dept dept) ;
	public List<Dept> list() ;
}
