package com.ddxx.microcloud.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ddxx.microcloud.dao.IDeptDAO;
import com.ddxx.microcloud.service.IDeptService;
import com.ddxx.vo.Dept;

@Service
public class DeptServiceImpl implements IDeptService {
	@Resource
	private IDeptDAO deptDAO ;
	@Override
	public Dept get(long id) {
		return this.deptDAO.findById(id);
	}

	@Override
	public boolean add(Dept dept) {
		return this.deptDAO.doCreate(dept);
	}

	@Override
	public List<Dept> list() {
		return this.deptDAO.findAll();
	}

}
